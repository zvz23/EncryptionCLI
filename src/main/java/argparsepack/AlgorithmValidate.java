package argparsepack;
import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import encryptionpack.Algorithm;

public class AlgorithmValidate implements IParameterValidator{
    @Override
    public void validate(String s, String s1) throws ParameterException {
        try{
            Algorithm.valueOf(s1.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new ParameterException(s1 + " invalid algorithm name");
        }
    }
}
