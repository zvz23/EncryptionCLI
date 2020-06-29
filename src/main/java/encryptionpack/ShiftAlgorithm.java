package encryptionpack;

public class ShiftAlgorithm implements EncryptionAlgorithm {

    @Override
    public String execute(String data, int key, boolean reversed) {
        StringBuilder builder = new StringBuilder();
        int cipherChar;
        for(Character letter : data.toCharArray()){
            if(!Character.isAlphabetic(letter)){
                builder.append(letter);
            }else{
                if(!reversed){
                    cipherChar = (int) letter + key;
                    if(Character.isUpperCase(letter)){

                        while(cipherChar > 90){
                            cipherChar = 65 + (cipherChar - 91);

                        }
                        builder.append((char) (cipherChar));
                    }
                    else{
                        while(cipherChar > 122){
                            cipherChar = 97 + (cipherChar - 123);

                        }
                        builder.append((char) (cipherChar));
                    }
                }
                else{
                    cipherChar = (int) letter - key;
                    if(Character.isUpperCase(letter)){
                        while (cipherChar < 65){
                            cipherChar = 91 - (65 - cipherChar);
                        }
                        builder.append((char)cipherChar);
                    }
                    else{
                        while (cipherChar < 97){
                            cipherChar = 123 - (97 - cipherChar);
                        }
                        builder.append((char)cipherChar);

                    }

                }
            }

        }
        return builder.toString();
    }
}