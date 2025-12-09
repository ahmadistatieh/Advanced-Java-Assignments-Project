package Assignment2.storage;

import Assignment2.core.Event;

public interface EventRepository {
    void save(Event event, String data);
}
