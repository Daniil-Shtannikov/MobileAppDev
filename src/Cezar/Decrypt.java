package Cezar;

import java.io.IOException;

import static Cezar.ProcessFile.processFile;

public class Decrypt {
    public static void decryptFile(String inputFileName, String outputFileName, int key, String ALPHABET, int ALPHABET_SIZE) throws IOException {
        processFile(inputFileName, outputFileName, key, false, ALPHABET, ALPHABET_SIZE);
    }

}
