package argparsepack;
import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class PositiveInt implements IParameterValidator{
    @Override
    public void validate(String name, String value) throws ParameterException {
        int n  = Integer.parseInt(value);
        if(n < 0){
            throw new ParameterException(name + " must be greater than or equal to 0");
        }
    }
}
