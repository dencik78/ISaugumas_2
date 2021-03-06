package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChooserCreaterAndSel {


    public void creteFile(String url, String text,String fileName) throws Exception {
        Path path = Paths.get(url + "/" +fileName);
        if (Files.exists(path)) {
            File myFile = new File(url + "/" +fileName);
            FileOutputStream myFileOver = new FileOutputStream(myFile, false);
            myFileOver.write(text.getBytes());
            myFileOver.close();
        } else {
            FileOutputStream f = new FileOutputStream(url + "/" +fileName);
            f.write(text.getBytes());
            f.flush();
            f.close();
        }
    }

    public String readTextFile(String url) throws Exception{
        File file = new File(url);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        return reader.readLine();
    }
}
