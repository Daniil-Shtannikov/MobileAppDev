package Cezar;

import java.io.*;

public class ProcessFile {
    static void processFile(String inputFileName, String outputFileName, int key, boolean encrypt) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = processLine(line, key, encrypt);
                writer.write(processedLine);
                writer.newLine();
            }
        }
    }

    private static String processLine(String line, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (Main.ALPHABET.indexOf(c) != -1) {
                int originalIndex = Main.ALPHABET.indexOf(c);
                int newIndex = encrypt ? (originalIndex + key) % Main.ALPHABET_SIZE : (originalIndex - key + Main.ALPHABET_SIZE) % Main.ALPHABET_SIZE;
                result.append(Main.ALPHABET.charAt(newIndex));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
