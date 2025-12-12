package Assignment2.processing;

import Assignment2.event.Event;
import Assignment2.event.EventType;
import Assignment2.logger.Logger;
import Assignment2.pipeline.EventProcessingStrategy;

import java.util.List;

public class EventProcessorProxy implements EventProcessorInter {

    private final EventProcessorInter real;
    private final Logger logger;

    public EventProcessorProxy(EventProcessorInter real, Logger logger) {
        this.real = real;
        this.logger = logger;
    }

    @Override
    public void process(Event e, List<EventProcessingStrategy> pipeline) {

        System.out.println("\n--- Processing Event " + e.getId()
                + " | Type: " + e.getType() + " ---");
        System.out.println("Step 1: Proxy check / security filtering");

        logger.logMessage("[Proxy] checking " + e.getId());

        if (e.getType() == EventType.SECURITY) {
            logger.logMessage("[Proxy] denied security event " + e.getId());
            System.out.println("--- Finished Event " + e.getId() + " ---");
            return;
        }

        long start = System.nanoTime();
        real.process(e, pipeline);
        long end = System.nanoTime();

        logger.logMessage("[Proxy] finished " + e.getId()
                + " in " + ((end - start) / 1_000_000.0) + " ms");

        System.out.println("--- Finished Event " + e.getId() + " ---");
    }
}
