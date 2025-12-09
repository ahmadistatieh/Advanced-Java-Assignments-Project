package Assignment2.storage;

import Assignment2.core.Event;

public class EventRepositoryProxy implements EventRepository {

    private final EventRepository target;
    private final ConnectionPool pool;

    public EventRepositoryProxy(EventRepository target, ConnectionPool pool) {
        this.target = target;
        this.pool = pool;
    }

    @Override
    public void save(Event event, String data) {
        DbConnection connection = pool.acquire();
        try {
            System.out.println("Using DB connection #" + connection.getId());
            target.save(event, data);
        } finally {
            pool.release(connection);
        }
    }
}
