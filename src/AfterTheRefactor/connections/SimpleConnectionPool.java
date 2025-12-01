package AfterTheRefactor.connections;

import java.util.ArrayDeque;
import java.util.Queue;

public class SimpleConnectionPool implements ConnectionPool {

    private final Queue<Connection> available = new ArrayDeque<>();
    private final int maxSize;
    private int totalCreated = 0;

    public SimpleConnectionPool(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public synchronized Connection acquire() throws InterruptedException {
        while (available.isEmpty() && totalCreated >= maxSize) {
            wait();
        }

        if (!available.isEmpty()) {
            return available.poll();
        }

        totalCreated++;
        return new Connection("Pool-Conn-" + totalCreated);
    }

    @Override
    public synchronized void release(Connection connection) {
        if (connection == null) {
            return;
        }
        available.offer(connection);
        notifyAll();
    }
}
