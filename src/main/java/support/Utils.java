package support;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Utils {


    public static void deleteFolder(File folder){
        try {
            FileUtils.deleteDirectory(folder);
        } catch (IOException e) {
            throw new RuntimeException("Pasta não encontrada...");
        }
    }

    public static String getRootPath(){
            return new File(System.getProperty("user.dir")).getAbsolutePath();
    }

}
