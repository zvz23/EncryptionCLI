package argparsepack;

import com.beust.jcommander.IStringConverter;

import java.io.File;

public class FileConverter implements IStringConverter<File> {
    @Override
    public File convert(String s) {
        return new File(s);
    }
}
