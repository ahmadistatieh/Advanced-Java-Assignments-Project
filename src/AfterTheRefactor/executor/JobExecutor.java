package AfterTheRefactor.executor;

import AfterTheRefactor.connections.Connection;
import AfterTheRefactor.connections.ConnectionManager;
import AfterTheRefactor.job.Job;

public class JobExecutor {

    private final JobStrategyFactory strategyFactory;
    private final ConnectionManager legacyConnectionManager; 

    public JobExecutor(JobStrategyFactory strategyFactory, ConnectionManager legacyConnectionManager) {
        this.strategyFactory = strategyFactory;
        this.legacyConnectionManager = legacyConnectionManager;
    }

    public void executeJob(Job job) {
        throw new UnsupportedOperationException("Use proxy with executeJobWithConnection().");
    }

    public void executeJobWithConnection(Job job, Connection connection) {
        JobStrategy strategy = strategyFactory.getStrategy(job.getType());
        if (strategy == null) {
            System.out.println("No strategy registered for job type: " + job.getType());
            return;
        }

        strategy.execute(job, connection);
    }
}
