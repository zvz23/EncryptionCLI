package encryptionpack;

public class UniShiftAlgorithm implements EncryptionAlgorithm{
    private static final EncryptionAlgorithm shift = new ShiftAlgorithm();
    private static final EncryptionAlgorithm uni = new UnicodeAlgorithm();
    @Override
    public String execute(String data, int key, boolean reversed) {
        StringBuilder builder = new StringBuilder();
        char[] dataArr = data.toCharArray();
        for(int i = 0; i < dataArr.length; i++){
            if(i % 2 == 0){
                builder.append(shift.execute(String.valueOf(dataArr[i]), key, reversed));
            }
            else{
                builder.append(uni.execute(String.valueOf(dataArr[i]), key, reversed));

            }
        }
        return builder.toString();
    }
}
