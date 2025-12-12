package Assignment2.database;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConnectionPool {

    private final Deque<Connection> pool = new ArrayDeque<>();
    private final int max;
    private int count = 0;

    public ConnectionPool(int initial, int max) {
        this.max = max;

        for (int i = 0; i < initial; i++) {
            pool.addLast(newConn());
        }
    }

    private Connection newConn() {
        return new Connection("C" + (++count));
    }

    public synchronized Connection acquire() {
        if (!pool.isEmpty()) return pool.removeFirst();

        if (count < max) return newConn();

        throw new RuntimeException("No connections available");
    }

    public synchronized void release(Connection c) {
        pool.addLast(c);
    }
}
