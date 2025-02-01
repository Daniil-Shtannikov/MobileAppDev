package Cezar;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static Cezar.CezarCipher.fileExists;

public class Main {

    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final int ALPHABET_SIZE = ALPHABET.length();

    public static void main(String[] Argv) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите режим работы (encrypt/decrypt): ");
        String mode = scanner.nextLine();

        System.out.print("Введите адрес файла для чтения: ");
        String inputFile = scanner.nextLine();

        System.out.print("Введите адрес файла для записи: ");
        String outputFile = scanner.nextLine();

        System.out.print("Введите ключ: ");
        int key = scanner.nextInt();

        try {
            if (!fileExists(inputFile)) {
                throw new FileNotFoundException("Файл не найден: " + inputFile);
            }

            if (key < 0 || key >= ALPHABET_SIZE) {
                throw new IllegalArgumentException("Ключ должен быть в диапазоне от 0 до " + (ALPHABET_SIZE - 1));
            }

            if (mode.equalsIgnoreCase("encrypt")) {
                encryptFile(inputFile, outputFile, key);
            } else if (mode.equalsIgnoreCase("decrypt")) {
                decryptFile(inputFile, outputFile, key);
            } else {
                throw new IllegalArgumentException("Неверный режим работы: " + mode);
            }

            System.out.println("Файл успешно обработан");

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean fileExists(String fileName) {
        Path path = Paths.get(fileName);
        return Files.exists(path);
    }

    public static void encryptFile(String inputFileName, String outputFileName, int key) throws IOException {
        processFile(inputFileName, outputFileName, key, true);
    }

    public static void decryptFile(String inputFileName, String outputFileName, int key) throws IOException {
        processFile(inputFileName, outputFileName, key, false);
    }

    private static void processFile(String inputFileName, String outputFileName, int key, boolean encrypt) throws IOException {
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