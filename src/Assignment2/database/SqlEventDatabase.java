package Assignment2.database;

public class SqlEventDatabase implements IEventDatabase {

    private final ConnectionPool pool;

    public SqlEventDatabase(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public void save(int id, String data) {
        Connection c = pool.acquire();
        try {
            c.execute("INSERT events(id,data) VALUES(" + id + "," + data + ")");
            System.out.println("[DB] saved " + id);
        } finally {
            pool.release(c);
        }
    }
}
