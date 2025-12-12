package Assignment2.pipeline;

public class EncryptStrategy implements EventProcessingStrategy {
    @Override
    public String process(String payload) {
        return "ENC(" + payload + ")";
    }
}
