package Cezar;

import java.io.IOException;
import static Cezar.ProcessFile.processFile;

public class Encrypt {
    public static void encryptFile(String inputFileName, String outputFileName, int key, String ALPHABET, int ALPHABET_SIZE) throws IOException {
        processFile(inputFileName, outputFileName, key, true, ALPHABET, ALPHABET_SIZE);
    }
}
