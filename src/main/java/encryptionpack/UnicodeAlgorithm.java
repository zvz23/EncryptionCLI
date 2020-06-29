package encryptionpack;

public class UnicodeAlgorithm implements EncryptionAlgorithm {

    @Override
    public String execute(String data, int key, boolean reversed) {
        StringBuilder builder = new StringBuilder();
        int cipherChar;
        for(Character letter : data.toCharArray()){
            if(!reversed){
                cipherChar = (int) letter + key;
                if(!(cipherChar > 127)){
                    builder.append((char) cipherChar);
                }
                else{
                    while(cipherChar > 127){
                        cipherChar -= 128;
                    }
                    builder.append((char)cipherChar);
                }
            }
            else{
                cipherChar = (int) letter - key;
                builder.append((char) cipherChar);
            }



        }
        return builder.toString();
    }
}
