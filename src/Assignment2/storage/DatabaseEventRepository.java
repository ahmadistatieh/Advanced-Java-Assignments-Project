package Assignment2.storage;

import Assignment2.core.Event;

public class DatabaseEventRepository implements EventRepository {

    @Override
    public void save(Event event, String data) {
        System.out.println(
                "Event[" + event.getType() + "] id=" + event.getId()
                        + "\nstored with data: " + data
        );
    }
}
