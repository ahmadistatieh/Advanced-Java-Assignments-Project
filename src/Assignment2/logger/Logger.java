package Assignment2.logger;

import Assignment2.event.Event;

public interface Logger {
    void log(Event event);
    void logMessage(String message);
}
