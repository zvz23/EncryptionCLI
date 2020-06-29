package otherutil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class FileManager {
    private String filePath;
    private File thisFile;
    public FileManager(String filePath){
        this.filePath = filePath;
        thisFile = null;
    }


    public boolean fileExists() {
        thisFile = new File(filePath);
        return thisFile.exists();
    }
    public String getDataFromFile(){
        String temp = "";
        try{
            Scanner scan = new Scanner(thisFile);
            if(scan.hasNext()){
                temp = scan.nextLine();
            }
        }catch (FileNotFoundException e){
           throw new IllegalArgumentException("File not found");
        }
        return temp;
    }

    public String getPath(){
        return this.filePath;
    }

    public void writeDataTo(String data, boolean append) {
        try{
            fileExists();
            FileWriter writer = new FileWriter(thisFile, append);
            writer.write(data);
            writer.close();
        }catch (IOException e){
            throw new IllegalArgumentException("Error in file");
        }

    }


}
