package Assignment2.typehandler;

import Assignment2.event.EventType;

import java.util.EnumMap;
import java.util.Map;

public class EventTypeStrategyFactory {

    private final Map<EventType, EventTypeStrategy> map = new EnumMap<>(EventType.class);

    public EventTypeStrategyFactory() {
        map.put(EventType.USER, new UserTypeStrategy());
        map.put(EventType.SYSTEM, new SystemTypeStrategy());
        map.put(EventType.SECURITY, new SecurityTypeStrategy());
    }

    public EventTypeStrategy get(EventType type) {
        return map.get(type);
    }
}
