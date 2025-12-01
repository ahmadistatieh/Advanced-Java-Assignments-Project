package AfterTheRefactor.executor;

import AfterTheRefactor.connections.Connection;
import AfterTheRefactor.job.Job;

public class ReportGenerationStrategy implements JobStrategy {

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("Executing Report Job: " + job.getName());
    }
}
