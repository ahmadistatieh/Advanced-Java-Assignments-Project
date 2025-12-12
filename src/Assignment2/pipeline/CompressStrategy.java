package Assignment2.pipeline;

public class CompressStrategy implements EventProcessingStrategy {
    @Override
    public String process(String payload) {
        return "CMP(" + payload + ")";
    }
}
