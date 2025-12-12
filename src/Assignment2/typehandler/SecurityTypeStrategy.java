package Assignment2.typehandler;

import Assignment2.event.Event;
import Assignment2.logger.Logger;
import Assignment2.template.AbstractEventTypeHandler;

public class SecurityTypeStrategy extends AbstractEventTypeHandler {

    @Override
    protected void doHandle(Event event, Logger logger) {
        logger.logMessage("[SECURITY] extra analysis for " + event.getId());
        logger.logMessage("[SecurityMonitor] alert for " + event.getId());
    }
}
