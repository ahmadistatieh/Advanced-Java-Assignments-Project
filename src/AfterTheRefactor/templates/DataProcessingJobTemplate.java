package AfterTheRefactor.templates;

import AfterTheRefactor.job.Job;

public class DataProcessingJobTemplate implements JobPrototype {

    private final String name;
    private final String config;
    private final String templateBody;

    public DataProcessingJobTemplate(String name, String config, String templateBody) {
        this.name = name;
        this.config = config;
        this.templateBody = templateBody;
    }

    @Override
    public JobPrototype cloneTemplate() {
        return new DataProcessingJobTemplate(name, config, templateBody);
    }

    @Override
    public Job createJobInstance() {
        String id = "DATA-" + System.currentTimeMillis();
        return new Job(id, "DATA", name, config);
    }

    @Override
    public String toString() {
        return "DataProcessingJobTemplate{" +
                "name='" + name + '\'' +
                ", templateBody='" + templateBody + '\'' +
                '}';
    }
}
