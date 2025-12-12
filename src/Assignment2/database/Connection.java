package Assignment2.database;

public class Connection {
    private final String id;

    public Connection(String id) {
        this.id = id;
    }

    public void execute(String cmd) {
        System.out.println("[Conn " + id + "] " + cmd);
    }
}
