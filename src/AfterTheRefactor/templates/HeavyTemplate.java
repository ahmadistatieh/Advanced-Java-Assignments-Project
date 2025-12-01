package AfterTheRefactor.templates;

import AfterTheRefactor.job.Job;

public class HeavyTemplate {
    private final String type;
    private final String name;
    private final String config;
    private final String templateBody;

    public HeavyTemplate(String type, String name, String config, String templateBody) {
        this.type = type;
        this.name = name;
        this.config = config;
        this.templateBody = templateBody;
    }

    public Job createJobInstance() {
        String id = templateBody + " _ " + type + "-" + System.currentTimeMillis();
        return new Job(id, type, name, config);
    }
}
