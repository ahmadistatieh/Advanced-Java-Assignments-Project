package Assignment2.pipeline;

public class AddMetadataStrategy implements EventProcessingStrategy {
    private final String meta;

    public AddMetadataStrategy(String meta) {
        this.meta = meta;
    }

    @Override
    public String process(String payload) {
        return "META(" + meta + ")::" + payload;
    }
}
