package encryptionpack;

public class Encryption {

    private EncryptionAlgorithm algorithm;
    private String data;
    private int key = 1;

    public Encryption(){
     this.algorithm = new ShiftAlgorithm();
     this.data = "";
    }
    public Encryption(EncryptionAlgorithm algorithm){
        setAlgorithm(algorithm);
    }

    public void setAlgorithm(EncryptionAlgorithm algorithm){
        this.algorithm = algorithm;
    }
    public void setKey(int newKey){
        this.key = newKey;
    }
    public void setData(String newData){
        this.data = newData;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public String encrypt(){
        return algorithm.execute(data, key, false);
    }
    public String encrypt(String data, int key){
        return algorithm.execute(data, key, false);
    }
    public String decrypt(){
        return algorithm.execute(data, key, true);
    }
    public String decrypt(String data, int key){
        return algorithm.execute(data, key, true);
    }
}
