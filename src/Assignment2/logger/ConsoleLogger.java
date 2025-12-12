package Assignment2.logger;

import Assignment2.event.Event;
import Assignment2.observer.Observer;

public class ConsoleLogger implements Logger, Observer {

    @Override
    public void log(Event event) {
        System.out.println("[LOGGER] event Id: " + event.getId()
                + " event Type: " + event.getType());
    }

    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void update(Event event) {
        log(event);
    }
}
