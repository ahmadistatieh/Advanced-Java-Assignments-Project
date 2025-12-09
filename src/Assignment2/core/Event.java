package Assignment2.core;

public class Event {

    private EventType type;
    private String payload;
    private String id;
    private EventProfile profile;
    private String metadata;

    public Event(EventType type, String payload) {
        this.type = type;
        this.payload = payload;
    }

    public EventType getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EventProfile getProfile() {
        return profile;
    }

    public void setProfile(EventProfile profile) {
        this.profile = profile;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
