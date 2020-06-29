package argparsepack;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.io.File;
public class FileValidation implements IParameterValidator {

    @Override
    public void validate(String s, String s1) throws ParameterException {
        if(!new File(s1).exists()){
            throw new ParameterException(s1 + "file not found");
        }

    }
}
