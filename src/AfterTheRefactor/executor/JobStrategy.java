package AfterTheRefactor.executor;

import AfterTheRefactor.connections.Connection;
import AfterTheRefactor.job.Job;

public interface JobStrategy {

    void execute(Job job, Connection connection);
}
