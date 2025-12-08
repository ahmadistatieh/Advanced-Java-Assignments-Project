package AfterTheRefactor.executor;

import AfterTheRefactor.connections.Connection;
import AfterTheRefactor.connections.ConnectionPool;
import AfterTheRefactor.job.Job;
import AfterTheRefactor.model.User;

public class JobExecutorProxy {

    private final JobExecutor realExecutor;
    private final ConnectionPool connectionPool;

    public JobExecutorProxy(JobExecutor realExecutor, ConnectionPool connectionPool) {
        this.realExecutor = realExecutor;
        this.connectionPool = connectionPool;
    }

    public void executeJob(Job job) {

        User user = job.getRequestedBy();
        String userName = (user == null) ? "unknown" : user.getName();

        if (user != null && !user.hasPermission(job.getType())) {
            System.out.println("Permission Denied for user: " + userName);
            System.out.println("AUTHORIZATION FAILED for job type: " + job.getType());
            return;
        }

        Connection connection = null;

        try {
            connection = connectionPool.acquire();
            System.out.println("Connection Opened  | ID = " + connection.getId());
            System.out.println();

            System.out.println("AuditLog ------------------------");
            System.out.println("Job ID   : " + job.getId());
            System.out.println("Owner    : " + userName);
            System.out.println("Job Type : " + job.getType());
            System.out.println("--------------------------------");
            System.out.println();

            realExecutor.executeJobWithConnection(job, connection);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Failed to acquire connection for job: " + job.getId());
        } finally {

            if (connection != null) {
                connectionPool.release(connection);
                System.out.println("Connection Closed | ID = " + connection.getId());
                System.out.println();
            }
        }
    }
}
