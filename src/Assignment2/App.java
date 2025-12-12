package Assignment2;

import Assignment2.dashboard.Dashboard;
import Assignment2.database.ConnectionPool;
import Assignment2.database.IEventDatabase;
import Assignment2.database.SqlEventDatabase;
import Assignment2.decorator.TimeLogger;
import Assignment2.event.Event;
import Assignment2.event.EventType;
import Assignment2.logger.ConsoleLogger;
import Assignment2.logger.Logger;
import Assignment2.observer.EventSubject;
import Assignment2.pipeline.AddMetadataStrategy;
import Assignment2.pipeline.EncryptStrategy;
import Assignment2.pipeline.EventProcessingStrategy;
import Assignment2.processing.EventProcessor;
import Assignment2.processing.EventProcessorInter;
import Assignment2.processing.EventProcessorProxy;
import Assignment2.typehandler.EventTypeStrategyFactory;

import java.util.List;

public class App {

    public static void main(String[] args) {

        ConsoleLogger baseLogger = new ConsoleLogger();
        Logger logger = new TimeLogger(baseLogger);

        Dashboard dashboard = new Dashboard(logger);

        ConnectionPool pool = new ConnectionPool(2, 5);
        IEventDatabase db = new SqlEventDatabase(pool);

        EventSubject subject = new EventSubject();
        subject.addObserver(dashboard);
        subject.addObserver(baseLogger);

        EventTypeStrategyFactory typeFactory = new EventTypeStrategyFactory();

        EventProcessorInter realProcessor =
                new EventProcessor(db, logger, subject, typeFactory);

        EventProcessorInter processor =
                new EventProcessorProxy(realProcessor, logger);

        Event user = new Event(1, EventType.USER, "user-click");
        Event system = new Event(2, EventType.SYSTEM, "system-update");

        List<EventProcessingStrategy> pipeline = List.of(
                new AddMetadataStrategy("user-42"),
                new EncryptStrategy()
        );

        processor.process(user, pipeline);
        processor.process(system, pipeline);
    }
}
