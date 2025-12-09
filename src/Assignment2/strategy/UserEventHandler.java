package Assignment2.strategy;

import Assignment2.core.Event;

public class UserEventHandler implements EventHandler {

    @Override
    public void handle(Event event) {
        System.out.println("USER handler done for " + event.getId());
    }
}
