package encryptionpack;

public interface EncryptionAlgorithm {

    public String execute(String data, int key, boolean reversed);
}
