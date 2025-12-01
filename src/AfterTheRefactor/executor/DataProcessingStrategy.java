package AfterTheRefactor.executor;

import AfterTheRefactor.connections.Connection;
import AfterTheRefactor.job.Job;

public class DataProcessingStrategy implements JobStrategy {

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("Executing Data Processing Job: " + job.getName());
    }
}
