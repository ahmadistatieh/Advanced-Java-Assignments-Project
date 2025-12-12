package Assignment2.template;

import Assignment2.event.Event;
import Assignment2.logger.Logger;
import Assignment2.typehandler.EventTypeStrategy;

public abstract class AbstractEventTypeHandler implements EventTypeStrategy {

    @Override
    public final void handle(Event event, Logger logger) {
        logStart(event, logger);
        doHandle(event, logger);
        logEnd(event, logger);
    }

    protected void logStart(Event event, Logger logger) {
        logger.logMessage("[Handler] start handling type: " + event.getType());
    }

    protected void logEnd(Event event, Logger logger) {
        logger.logMessage("[Handler] finished handling type: " + event.getType());
    }

    protected abstract void doHandle(Event event, Logger logger);
}
