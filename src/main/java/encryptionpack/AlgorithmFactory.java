package encryptionpack;

public abstract class AlgorithmFactory {

    public static EncryptionAlgorithm getAlgorithm(Algorithm algoType){
        switch (algoType){
            case SHIFT:
                return new ShiftAlgorithm();
            case UNICODE:
                return new UnicodeAlgorithm();
            case UNISHIFT:
                return new UniShiftAlgorithm();
            default:
                return null;
        }
    }

}
