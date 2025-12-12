package Assignment2.typehandler;

import Assignment2.event.Event;
import Assignment2.logger.Logger;
import Assignment2.template.AbstractEventTypeHandler;

public class SystemTypeStrategy extends AbstractEventTypeHandler {

    @Override
    protected void doHandle(Event event, Logger logger) {
        logger.logMessage("[SYSTEM] system audit log " + event.getId());
    }
}
