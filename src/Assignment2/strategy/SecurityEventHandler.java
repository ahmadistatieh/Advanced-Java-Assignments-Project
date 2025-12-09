package Assignment2.strategy;

import Assignment2.core.Event;

public class SecurityEventHandler implements EventHandler {

    @Override
    public void handle(Event event) {
        System.out.println("SECURITY handler done for " + event.getId());
    }
}
