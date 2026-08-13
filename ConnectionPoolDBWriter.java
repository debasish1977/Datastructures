import java.sql.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * APPROACH 2: Connection Pool with Lock-Free Updates
 * Time Complexity: O(1) amortized per insert
 * Space Complexity: O(c) where c = connection pool size (fixed)
 */
public class ConnectionPoolDBWriter {
    
    private static final int POOL_SIZE = 16;
    private static final int QUEUE_SIZE = 50000;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    
    private final BlockingQueue<DataRecord> queue;
    private final ExecutorService executor;
    private final AtomicLong processedCount;
    private final ConnectionPool connPool;
    
    static class ConnectionPool {
        private final BlockingQueue<Connection> available;
        private final int poolSize;
        
        ConnectionPool(int size, String url, String user, String pass) throws SQLException {
            this.poolSize = size;
            this.available = new LinkedBlockingQueue<>(size);
            
            for (int i = 0; i < size; i++) {
                available.offer(DriverManager.getConnection(url, user, pass));
            }
        }
        
        Connection getConnection() throws InterruptedException {
            return available.take();
        }
        
        void returnConnection(Connection conn) {
            available.offer(conn);
        }
        
        void shutdown() {
            Connection conn;
            while ((conn = available.poll()) != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public ConnectionPoolDBWriter(String url, String user, String password) 
            throws SQLException {
        this.queue = new LinkedBlockingQueue<>(QUEUE_SIZE);
        this.executor = Executors.newFixedThreadPool(POOL_SIZE);
        this.processedCount = new AtomicLong(0);
        this.connPool = new ConnectionPool(POOL_SIZE, url, user, password);
    }
    
    public void startWorkers() {
        for (int i = 0; i < POOL_SIZE; i++) {
            executor.submit(this::processQueue);
        }
    }
    
    private void processQueue() {
        try {
            String sql = "INSERT INTO records (id, name, value) VALUES (?, ?, ?)";
            
            while (!Thread.currentThread().isInterrupted()) {
                DataRecord record = queue.poll(2, TimeUnit.SECONDS);
                
                if (record != null) {
                    Connection conn = connPool.getConnection();
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setInt(1, record.id);
                        pstmt.setString(2, record.name);
                        pstmt.setString(3, record.value);
                        pstmt.executeUpdate();
                        processedCount.incrementAndGet();
                    } finally {
                        connPool.returnConnection(conn);
                    }
                }
            }
        } catch (InterruptedException | SQLException e) {
            Thread.currentThread().interrupt();
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
        connPool.shutdown();
    }
    
    public long getProcessedCount() {
        return processedCount.get();
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
}
