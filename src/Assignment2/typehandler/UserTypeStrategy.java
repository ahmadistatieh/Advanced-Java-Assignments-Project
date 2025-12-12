package Assignment2.typehandler;

import Assignment2.event.Event;
import Assignment2.logger.Logger;
import Assignment2.template.AbstractEventTypeHandler;

public class UserTypeStrategy extends AbstractEventTypeHandler {

    @Override
    protected void doHandle(Event event, Logger logger) {
        logger.logMessage("[USER] user audit log " + event.getId());
    }
}
