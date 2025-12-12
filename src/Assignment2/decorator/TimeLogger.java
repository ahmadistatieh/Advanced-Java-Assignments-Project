package Assignment2.decorator;

import Assignment2.event.Event;
import Assignment2.logger.Logger;

import java.time.LocalTime;

public class TimeLogger extends LoggerDecorator {

    public TimeLogger(Logger wrappee) {
        super(wrappee);
    }

    @Override
    public void log(Event event) {
        System.out.print("[" + LocalTime.now() + "] ");
        super.log(event);
    }

    @Override
    public void logMessage(String message) {
        String decorated = "[" + LocalTime.now() + "] " + message;
        super.logMessage(decorated);
    }
}
