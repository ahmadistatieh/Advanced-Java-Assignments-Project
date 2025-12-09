package Assignment2.strategy;

import Assignment2.core.Event;

public class SystemEventHandler implements EventHandler {

    @Override
    public void handle(Event event) {
        System.out.println("SYSTEM handler done for " + event.getId());
    }
}
