package Assignment2;

import Assignment2.core.*;
import Assignment2.processing.EventProcessor;
import Assignment2.storage.*;

public class App {

    public static void main(String[] args) {

        EventProfileRegistry profileRegistry = new EventProfileRegistry();

        ConnectionPool pool = new ConnectionPool(2);

        EventRepository realRepo = new DatabaseEventRepository();
        EventRepository proxyRepo = new EventRepositoryProxy(realRepo, pool);

        EventProcessor processor =
                new EventProcessor(proxyRepo, profileRegistry);

        Event e1 = new Event(EventType.USER, "user-click");
        processor.process(e1);

        System.out.println("=================");

        Event e2 = new Event(EventType.SECURITY, "failed-login");
        processor.process(e2);
    }
}
