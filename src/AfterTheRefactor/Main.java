package AfterTheRefactor;

import AfterTheRefactor.connections.ConnectionManager;
import AfterTheRefactor.connections.ConnectionPool;
import AfterTheRefactor.connections.SimpleConnectionPool;
import AfterTheRefactor.executor.*;
import AfterTheRefactor.job.Job;
import AfterTheRefactor.model.User;
import AfterTheRefactor.templates.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("TMPS App\n");

        ConnectionPool pool = new SimpleConnectionPool(10);

        JobStrategyFactory strategyFactory = new JobStrategyFactory();
        strategyFactory.register("EMAIL", new EmailJobStrategy());
        strategyFactory.register("DATA", new DataProcessingStrategy());
        strategyFactory.register("REPORT", new ReportGenerationStrategy());

        ConnectionManager legacyConnectionManager = new ConnectionManager();
        JobExecutor realExecutor = new JobExecutor(strategyFactory, legacyConnectionManager);
        JobExecutorProxy proxy = new JobExecutorProxy(realExecutor, pool);

        JobTemplateRegistry registry = new JobTemplateRegistry();
        String heavyBody = "Large template body (created once)";

        registry.registerTemplate(
                "MONTHLY_REPORT",
                new ReportJobTemplate("MonthlyReport", "format=PDF;brand=TaskMaster", heavyBody)
        );

        registry.registerTemplate(
                "MONTHLY_EMAIL_REPORT",
                new EmailJobTemplate("Monthly email report", "format=PDF;all=true", heavyBody)
        );

        registry.registerTemplate(
                "DATA_JOB_TEMPLATE",
                new DataProcessingJobTemplate("DailyDataProcessing", "mode=FULL;source=A", heavyBody)
        );

        User alice = new User("alice", Arrays.asList("EMAIL", "REPORT"));

        System.out.println("Run REPORT job (Monthly Report)");
        Job reportJob = registry.createJobFromTemplate("MONTHLY_REPORT");
        if (reportJob != null) {
            reportJob.setRequestedBy(alice);
            proxy.executeJob(reportJob);
        }

        System.out.println("-----------------------------------------------");

        System.out.println("\nRun EMAIL job (Monthly Email Report)");
        Job emailJob = registry.createJobFromTemplate("MONTHLY_EMAIL_REPORT");
        if (emailJob != null) {
            emailJob.setRequestedBy(alice);
            proxy.executeJob(emailJob);
        }

        System.out.println("-----------------------------------------------");

        System.out.println("\nRun DATA job (should be denied)");
        Job dataJob = registry.createJobFromTemplate("DATA_JOB_TEMPLATE");
        if (dataJob != null) {
            dataJob.setRequestedBy(alice);
            proxy.executeJob(dataJob);
        }
    }
}
