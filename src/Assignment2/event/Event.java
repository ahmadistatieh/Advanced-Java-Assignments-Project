package Assignment2.event;

public class Event {
    private final int id;
    private final EventType type;
    private final String payload;

    public Event(int id, EventType type, String payload) {
        this.id = id;
        this.type = type;
        this.payload = payload;
    }

    public int getId() { return id; }
    public EventType getType() { return type; }
    public String getPayload() { return payload; }

    public Event cloneWithId(int newId) {
        return new Event(newId, this.type, this.payload);
    }

}
