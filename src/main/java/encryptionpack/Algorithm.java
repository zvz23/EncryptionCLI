package encryptionpack;

public enum Algorithm {

    SHIFT("Shift"), UNICODE("Unicode");
    private String value;
    private Algorithm(String value){
        this.value = value;
    }


}
