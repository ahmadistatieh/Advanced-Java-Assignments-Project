package AfterTheRefactor.executor;

import java.util.HashMap;
import java.util.Map;

public class JobStrategyFactory {

    private final Map<String, JobStrategy> strategies = new HashMap<>();

    public JobStrategyFactory() {
    }

    public void register(String jobType, JobStrategy strategy) {
        strategies.put(jobType, strategy);
    }

    public JobStrategy getStrategy(String jobType) {
        return strategies.get(jobType);
    }
}
