package Cezar;

import java.io.*;

public class ProcessFile {
    static void processFile(String inputFileName, String outputFileName, int key, boolean encrypt, String ALPHABET, int ALPHABET_SIZE) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = processLine(line, key, encrypt, ALPHABET, ALPHABET_SIZE);
                writer.write(processedLine);
                writer.newLine();
            }
        }
    }

    private static String processLine(String line, int key, boolean encrypt, String ALPHABET, int ALPHABET_SIZE) {
        StringBuilder result = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (ALPHABET.indexOf(c) != -1) {
                int originalIndex = ALPHABET.indexOf(c);
                int newIndex = encrypt ? (originalIndex + key) % ALPHABET_SIZE : (originalIndex - key + ALPHABET_SIZE) % ALPHABET_SIZE;
                result.append(ALPHABET.charAt(newIndex));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
