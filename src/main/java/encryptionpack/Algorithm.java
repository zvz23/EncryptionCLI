package encryptionpack;

public enum Algorithm {

    SHIFT("Shift"), UNICODE("Unicode"), UNISHIFT("UniShift");
    private String value;
    private Algorithm(String value){
        this.value = value;
    }


}
