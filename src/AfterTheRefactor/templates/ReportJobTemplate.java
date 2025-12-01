package AfterTheRefactor.templates;

import AfterTheRefactor.job.Job;

public class ReportJobTemplate implements JobPrototype {

    private final String name;
    private final String config;
    private final String templateBody;

    public ReportJobTemplate(String name, String config, String templateBody) {
        this.name = name;
        this.config = config;
        this.templateBody = templateBody;
    }

    @Override
    public JobPrototype cloneTemplate() {
        return new ReportJobTemplate(name, config, templateBody);
    }

    @Override
    public Job createJobInstance() {
        String id = "REPORT-" + System.currentTimeMillis();
        return new Job(id, "REPORT", name, config);
    }

    @Override
    public String toString() {
        return "ReportJobTemplate{" +
                "name='" + name + '\'' +
                ", templateBody='" + templateBody + '\'' +
                '}';
    }
}
