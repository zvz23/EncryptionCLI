package mainpack;

import argparsepack.MainArgs;
import com.beust.jcommander.JCommander;
import encryptionpack.AlgorithmFactory;
import encryptionpack.Encryption;
import otherutil.FileManager;

import java.io.IOException;


public class Main {

    private static String output;
    public static void main(String[] args) throws IOException {
        MainArgs mainArgs = new MainArgs();
        Encryption encryption = new Encryption();
        JCommander.newBuilder()
                .addObject(mainArgs)
                .build()
                .parse(args);
        initializeEncryptionObj(encryption, mainArgs);
        switch (mainArgs.getMode()){
            case "enc":
                output = encryption.encrypt();
                break;
            case "dec":
                output = encryption.decrypt();
        }
        decideOutput(output, mainArgs);

    }

    private static void decideOutput(String tempData, MainArgs args){
        if(args.isHasOut()){
            FileManager manager = new FileManager(args.getOutPath());
            manager.writeDataTo(tempData, false);
            System.out.println("Data was stored at " + manager.getPath());
            operationInfo(args);
        }
        else{
            System.out.println("Output: " + tempData);
            operationInfo(args);
        }
    }

    private static void operationInfo(MainArgs args){
        System.out.println("[Operation Info]");
        System.out.println("Type: " + args.getMode() == "enc" ? "Encryption":"Decryption");
        System.out.println("Key: " + args.getKey());
        System.out.println("Algorithm: " + args.getAlgo().toString());
    }

    private static void initializeEncryptionObj(Encryption encryption, MainArgs args){
        encryption.setKey(args.getKey());
        encryption.setAlgorithm(AlgorithmFactory.getAlgorithm(args.getAlgo()));
        if(!args.getRawData().equals("")){
            encryption.setData(args.getRawData());
        }
        else{
            if(args.isHasFile()){
                String location = args.getFilePathIfExists();
                FileManager manager = new FileManager(location);
                manager.fileExists();
                encryption.setData(manager.getDataFromFile());
            }
            else{
                throw new IllegalArgumentException("No data input");
            }
        }
    }
    
}
