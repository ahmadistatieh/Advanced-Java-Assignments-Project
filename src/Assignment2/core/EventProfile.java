package Assignment2.core;

public class EventProfile implements Cloneable {

    private boolean encrypt;
    private boolean compress;
    private boolean addMetadata;

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public boolean isCompress() {
        return compress;
    }

    public void setCompress(boolean compress) {
        this.compress = compress;
    }

    public boolean isAddMetadata() {
        return addMetadata;
    }

    public void setAddMetadata(boolean addMetadata) {
        this.addMetadata = addMetadata;
    }

    @Override
    public EventProfile clone() {
        try {
            return (EventProfile) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported");
        }
    }
}
