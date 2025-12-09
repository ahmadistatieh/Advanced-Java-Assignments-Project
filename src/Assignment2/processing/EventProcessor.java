package Assignment2.processing;

import Assignment2.core.*;
import Assignment2.strategy.*;
import Assignment2.storage.EventRepository;

import java.util.HashMap;
import java.util.Map;

public class EventProcessor {

    private final Map<EventType, EventHandler> handlers = new HashMap<>();
    private final EventRepository repository;
    private final EventProfileRegistry profileRegistry;
    private static int nextId = 1;


    public EventProcessor(EventRepository repository,
                          EventProfileRegistry profileRegistry) {

        this.repository = repository;
        this.profileRegistry = profileRegistry;

        handlers.put(EventType.USER, new UserEventHandler());
        handlers.put(EventType.SYSTEM, new SystemEventHandler());
        handlers.put(EventType.SECURITY, new SecurityEventHandler());
    }

    public void process(Event event) {

        EventProfile profile = profileRegistry.getProfile(event.getType());
        event.setProfile(profile);

        String data = event.getPayload();

        if (profile.isEncrypt()) {
            data = "ENC(" + data + ")";
        }

        if (profile.isCompress()) {
            data = "CMP(" + data + ")";
        }

        if (profile.isAddMetadata() && event.getMetadata() != null) {
            data = "META(" + event.getMetadata() + ")::" + data;
        }

        event.setId(String.valueOf(nextId++));

        repository.save(event, data);

        EventHandler handler = handlers.get(event.getType());
        if (handler != null) {
            handler.handle(event);
        }
    }
}
