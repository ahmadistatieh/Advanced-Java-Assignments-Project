package AfterTheRefactor.templates;

import AfterTheRefactor.job.Job;

public interface JobPrototype {

    JobPrototype cloneTemplate();
    Job createJobInstance();
}
