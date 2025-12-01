package AfterTheRefactor.connections;

public class ConnectionManager {
    private int counter = 0;
    private final int MAX = 10;

    public Connection createConnection() {
        int n = ++counter;
        if (n > MAX) {
            System.out.println("Warning: too many BeforeTheRefactor.BeforeTheRefactor.connections created. Still creating (naive).");
            return null;
        }
        return new Connection("Conn-" + n);
    }

    public void closeConnection(Connection c) {
        if (c == null) {
            return;
        }
        System.out.printf("[ConnectionManager] Closing connection %s (naive).%n", c.getId());
    }
}
