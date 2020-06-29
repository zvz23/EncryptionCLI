package argparsepack;

import com.beust.jcommander.Parameter;
import encryptionpack.Algorithm;

import java.io.File;
import java.io.IOException;

public class MainArgs {
   public String getMode() {
      return mode;
   }

   public int getKey() {
      return key;
   }

   public Algorithm getAlgo() {
      return algo;
   }

   public String getRawData() {
      return rawData;
   }

   public File getFile() {
      return file;
   }

   public String getOutPath() {
      return outPath;
   }
   @Parameter(names = {"-mode"}, description = "encryption or decryption")
   private String mode = "enc";

   @Parameter(names = {"-key"}, description = "key", validateWith = PositiveInt.class)
   private Integer key = 1;

   @Parameter(names = {"-alg"}, description = "algorithm", validateWith = AlgorithmValidate.class)
   private Algorithm algo = Algorithm.SHIFT;

   @Parameter(names = {"-data"}, description = "data to encrypt or decrypt")
   private String rawData = "";

   @Parameter(names = {"-in"}, converter = FileConverter.class, description = "data file", validateWith = FileValidation.class)
   private File file;

   @Parameter(names = {"-out"}, description = "output file")
   private String outPath = null;

   private boolean hasFile;
   private boolean hasOut;



   public boolean isHasFile() {
      return file != null;
   }

   public boolean isHasOut() {
      return outPath != null;
   }

   public String getFilePathIfExists() {
      try{
         return file.getCanonicalPath();

      }catch (IOException e){
         throw new IllegalArgumentException("Error no file found");
      }
   }

}


