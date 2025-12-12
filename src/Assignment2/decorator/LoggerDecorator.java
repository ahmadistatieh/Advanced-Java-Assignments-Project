package Assignment2.decorator;

import Assignment2.event.Event;
import Assignment2.logger.Logger;

public abstract class LoggerDecorator implements Logger {

    protected final Logger wrappee;

    protected LoggerDecorator(Logger wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void log(Event event) {
        wrappee.log(event);
    }

    @Override
    public void logMessage(String message) {
        wrappee.logMessage(message);
    }
}
