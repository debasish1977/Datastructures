import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * APPROACH 3: Hybrid - Thread Pool + Bulk Inserts (BEST PERFORMANCE)
 * Time Complexity: O(n/t/b) where n = records, t = threads, b = batch size
 * Space Complexity: O(b) for batch buffer (fixed and minimal)
 */
public class OptimizedBulkDBWriter implements AutoCloseable {
    
    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int BATCH_SIZE = 5000;
    private static final int QUEUE_SIZE = 100000;
    private static final long FLUSH_INTERVAL_MS = 1000;
    
    private final BlockingQueue<DataRecord> queue;
    private final ExecutorService executor;
    private final HikariDataSource dataSource;
    private volatile boolean running = true;
    private final ScheduledExecutorService scheduler;
    
    public OptimizedBulkDBWriter(String url, String user, String password) {
        this.queue = new LinkedBlockingQueue<>(QUEUE_SIZE);
        this.executor = Executors.newFixedThreadPool(THREAD_COUNT);
        this.scheduler = Executors.newScheduledThreadPool(1);
        
        // Initialize HikariCP connection pool (production-grade)
        this.dataSource = new HikariDataSource();
        this.dataSource.setJdbcUrl(url);
        this.dataSource.setUsername(user);
        this.dataSource.setPassword(password);
        this.dataSource.setMaximumPoolSize(THREAD_COUNT * 2);
        this.dataSource.setMinimumIdle(THREAD_COUNT);
        this.dataSource.setConnectionTimeout(10000);
    }
    
    public void start() {
        // Start worker threads
        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.submit(this::batchInsertWorker);
        }
    }
    
    private void batchInsertWorker() {
        List<DataRecord> batch = new ArrayList<>(BATCH_SIZE);
        String sql = "INSERT INTO records (id, name, value) VALUES (?, ?, ?)";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            conn.setAutoCommit(false);
            
            while (running) {
                // Drain queue with timeout
                DataRecord record = queue.poll(100, TimeUnit.MILLISECONDS);
                
                if (record != null) {
                    batch.add(record);
                }
                
                // Execute batch when full or when timeout occurs with data
                if (batch.size() >= BATCH_SIZE || 
                    (record == null && !batch.isEmpty() && 
                     queue.isEmpty())) {
                    executeBatchInsert(pstmt, batch, conn);
                    batch.clear();
                }
            }
            
            // Flush remaining records
            if (!batch.isEmpty()) {
                executeBatchInsert(pstmt, batch, conn);
            }
        } catch (SQLException | InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void executeBatchInsert(PreparedStatement pstmt, List<DataRecord> batch, 
                                   Connection conn) throws SQLException {
        for (DataRecord record : batch) {
            pstmt.setInt(1, record.id);
            pstmt.setString(2, record.name);
            pstmt.setString(3, record.value);
            pstmt.addBatch();
        }
        
        pstmt.executeBatch();
        conn.commit();
    }
    
    public void addRecord(DataRecord record) throws InterruptedException {
        queue.put(record);
    }
    
    public void addRecordsBulk(Collection<DataRecord> records) throws InterruptedException {
        for (DataRecord record : records) {
            queue.put(record);
        }
    }
    
    public int getQueueSize() {
        return queue.size();
    }
    
    public void stop() throws InterruptedException {
        running = false;
        executor.shutdown();
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }
    
    @Override
    public void close() throws Exception {
        stop();
        scheduler.shutdown();
        if (dataSource != null) {
            dataSource.close();
        }
    }
    
    static class DataRecord {
        int id;
        String name;
        String value;
        
        DataRecord(int id, String name, String value) {
            this.id = id;
            this.name = name;
            this.value = value;
        }
    }
    
    // Example usage
    public static void main(String[] args) throws Exception {
        try (OptimizedBulkDBWriter writer = new OptimizedBulkDBWriter(
                "jdbc:mysql://localhost:3306/mydb", "root", "password")) {
            
            writer.start();
            
            // Simulate high-throughput data generation
            int totalRecords = 1_000_000;
            for (int i = 0; i < totalRecords; i++) {
                writer.addRecord(new DataRecord(i, "record_" + i, "value_" + i));
            }
            
            writer.stop();
        }
    }
}
