package AfterTheRefactor.templates;

import AfterTheRefactor.job.Job;

public class EmailJobTemplate implements JobPrototype {

    private final String name;
    private final String config;
    private final String templateBody;

    public EmailJobTemplate(String name, String config, String templateBody) {
        this.name = name;
        this.config = config;
        this.templateBody = templateBody;
    }

    @Override
    public JobPrototype cloneTemplate() {
        return new EmailJobTemplate(name, config, templateBody);
    }

    @Override
    public Job createJobInstance() {
        String id = "EMAIL-" + System.currentTimeMillis();
        return new Job(id, "EMAIL", name, config);
    }

    @Override
    public String toString() {
        return "EmailJobTemplate{" +
                "name='" + name + '\'' +
                ", templateBody='" + templateBody + '\'' +
                '}';
    }
}
