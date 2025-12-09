package Assignment2.storage;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {

    private final Queue<DbConnection> pool = new LinkedList<>();

    public ConnectionPool(int size) {
        for (int i = 0; i < size; i++) {
            pool.add(new DbConnection(i));
        }
    }

    public synchronized DbConnection acquire() {
        return pool.poll();
    }

    public synchronized void release(DbConnection connection) {
        pool.add(connection);
    }
}
