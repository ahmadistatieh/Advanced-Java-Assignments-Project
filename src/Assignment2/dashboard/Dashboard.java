package Assignment2.dashboard;

import Assignment2.event.Event;
import Assignment2.logger.Logger;
import Assignment2.observer.Observer;

public class Dashboard implements Observer {

    private final Logger logger;

    public Dashboard(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void update(Event event) {
        logger.logMessage(String.format(
                "[Dashboard] metrics updated for %s, payload: %s",
                event.getId(), event.getPayload()
        ));
    }
}
