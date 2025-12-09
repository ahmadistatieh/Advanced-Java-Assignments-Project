package Assignment2.core;

import java.util.HashMap;
import java.util.Map;

public class EventProfileRegistry {

    private final Map<EventType, EventProfile> profiles = new HashMap<>();

    public EventProfileRegistry() {

        EventProfile user = new EventProfile();
        user.setEncrypt(true);
        user.setAddMetadata(true);

        EventProfile security = new EventProfile();
        security.setCompress(true);

        EventProfile system = new EventProfile();

        profiles.put(EventType.USER, user);
        profiles.put(EventType.SECURITY, security);
        profiles.put(EventType.SYSTEM, system);
    }

    public EventProfile getProfile(EventType type) {
        return profiles.get(type).clone();
    }
}
