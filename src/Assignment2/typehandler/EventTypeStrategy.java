package Assignment2.typehandler;

import Assignment2.event.Event;
import Assignment2.logger.Logger;

public interface EventTypeStrategy {
    void handle(Event event, Logger logger);
}
