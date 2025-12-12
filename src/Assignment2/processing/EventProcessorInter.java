package Assignment2.processing;

import Assignment2.event.Event;
import Assignment2.pipeline.EventProcessingStrategy;

import java.util.List;

public interface EventProcessorInter {
    void process(Event event, List<EventProcessingStrategy> pipeline);
}
