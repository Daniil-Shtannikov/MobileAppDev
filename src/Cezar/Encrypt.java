package Cezar;

import java.io.IOException;
import static Cezar.ProcessFile.processFile;

public class Encrypt {
    public static void encryptFile(String inputFileName, String outputFileName, int key) throws IOException {
        processFile(inputFileName, outputFileName, key, true);
    }
}
