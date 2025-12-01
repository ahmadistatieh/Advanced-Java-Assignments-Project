package AfterTheRefactor.templates;

import AfterTheRefactor.job.Job;

import java.util.HashMap;
import java.util.Map;

public class JobTemplateRegistry {

    private final Map<String, JobPrototype> templates = new HashMap<>();

    public void registerTemplate(String key, JobPrototype prototype) {
        templates.put(key, prototype);
    }

    public Job createJobFromTemplate(String key) {
        JobPrototype prototype = templates.get(key);
        if (prototype == null) {
            System.out.println("No template registered for key: " + key);
            return null;
        }

        JobPrototype copy = prototype.cloneTemplate();
        return copy.createJobInstance();
    }
}
