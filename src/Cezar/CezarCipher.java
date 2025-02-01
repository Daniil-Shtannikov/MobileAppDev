package Cezar;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CezarCipher{

    public boolean isValidKey(int key, char[] alpha) {
        return false;
    };


    public static boolean fileExists(String fileName) {
        Path path = Paths.get(fileName);
        return Files.exists(path);
    }
}
