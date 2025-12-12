package Assignment2.processing;

import Assignment2.database.IEventDatabase;
import Assignment2.event.Event;
import Assignment2.logger.Logger;
import Assignment2.observer.EventSubject;
import Assignment2.pipeline.EventProcessingStrategy;
import Assignment2.typehandler.EventTypeStrategyFactory;

import java.util.List;

public class EventProcessor implements EventProcessorInter {

    private final IEventDatabase database;
    private final Logger logger;
    private final EventSubject subject;
    private final EventTypeStrategyFactory typeFactory;

    public EventProcessor(IEventDatabase database,
                          Logger logger,
                          EventSubject subject,
                          EventTypeStrategyFactory typeFactory) {
        this.database = database;
        this.logger = logger;
        this.subject = subject;
        this.typeFactory = typeFactory;
    }

    @Override
    public void process(Event e, List<EventProcessingStrategy> strategies) {

        if (e.getPayload() == null || e.getPayload().isEmpty()) {
            logger.logMessage("[EventProcessor] invalid event: " + e.getId());
            return;
        }

        // Step 2: observers
        System.out.println("Step 2: Notifying observers");
        subject.notifyObservers(e);

        // Step 3: pipeline
        System.out.println("Step 3: Applying strategies");
        String data = e.getPayload();
        for (EventProcessingStrategy strategy : strategies) {
            data = strategy.process(data);
            System.out.println("[Strategy] Applied " + strategy.getClass().getSimpleName()
                    + " -> payload: " + data);
        }

        // Save to DB
        database.save(e.getId(), data);

        // Step 4: type-specific handler
        System.out.println("Step 4: Executing event-type strategy");
        typeFactory.get(e.getType()).handle(e, logger);
    }
}
