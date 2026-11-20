import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * APPROACH 1: Thread Pool + Batch Processing (RECOMMENDED)
 * Time Complexity: O(n/k) where n = total records, k = batch size
 * Space Complexity: O(b) where b = batch size (fixed, memory-efficient)
 */
public class MultiThreadedDBWriter {
    
    private static final int BATCH_SIZE = 1000;
    private static final int THREAD_POOL_SIZE = 8;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    
    private final ExecutorService executor;
    private final BlockingQueue<DataRecord> queue;
    private final AtomicInteger successCount;
    private final AtomicInteger failureCount;
    
    public MultiThreadedDBWriter(int queueCapacity) {
        this.executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        this.queue = new LinkedBlockingQueue<>(queueCapacity);
        this.successCount = new AtomicInteger(0);
        this.failureCount = new AtomicInteger(0);
    }
    
    /**
     * Optimized batch insert using PreparedStatement
     * Time: O(b*m) where b = batch size, m = insert time
     * Space: O(b) for batch list
     */
    public void startBatchWriter() {
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executor.submit(() -> {
                List<DataRecord> batch = new ArrayList<>(BATCH_SIZE);
                
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
                    String sql = "INSERT INTO records (id, name, value) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    
                    while (!Thread.currentThread().isInterrupted()) {
                        // Poll with timeout to avoid blocking indefinitely
                        DataRecord record = queue.poll(5, TimeUnit.SECONDS);
                        
                        if (record != null) {
                            batch.add(record);
                        }
                        
                        // Execute batch when full or on timeout with records
                        if (batch.size() >= BATCH_SIZE || 
                            (record == null && !batch.isEmpty())) {
                            executeBatch(pstmt, batch);
                            batch.clear();
                        }
                    }
                } catch (SQLException | InterruptedException e) {
                    failureCount.addAndGet(batch.size());
                    Thread.currentThread().interrupt();
                }
            });
        }
    }
    
    private void executeBatch(PreparedStatement pstmt, List<DataRecord> batch) 
            throws SQLException {
        for (DataRecord record : batch) {
            pstmt.setInt(1, record.getId());
            pstmt.setString(2, record.getName());
            pstmt.setString(3, record.getValue());
            pstmt.addBatch();
        }
        
        try {
            int[] results = pstmt.executeBatch();
            successCount.addAndGet(results.length);
        } catch (SQLException e) {
            failureCount.addAndGet(batch.size());
            throw e;
        }
    }
    
    public void addRecord(DataRecord record) throws InterruptedException {
        queue.put(record);
    }
    
    public void shutdown() throws InterruptedException {
        executor.shutdown();
        if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        MultiThreadedDBWriter writer = new MultiThreadedDBWriter(10000);
        writer.startBatchWriter();
        
        // Simulate data production
        for (int i = 0; i < 100000; i++) {
            writer.addRecord(new DataRecord(i, "record_" + i, "value_" + i));
        }
        
        writer.shutdown();
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
        
        int getId() { return id; }
        String getName() { return name; }
        String getValue() { return value; }
    }
}
