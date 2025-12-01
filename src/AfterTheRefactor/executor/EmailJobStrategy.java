package AfterTheRefactor.executor;

import AfterTheRefactor.connections.Connection;
import AfterTheRefactor.job.Job;

public class EmailJobStrategy implements JobStrategy {

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("Email Job Executed: " + job.getName());
    }
}
