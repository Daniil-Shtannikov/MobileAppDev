package Cezar;

import java.io.*;
import java.util.Scanner;

import static Cezar.CezarCipher.fileExists;
import static Cezar.Decrypt.decryptFile;
import static Cezar.Encrypt.encryptFile;
import static Cezar.BruteForce.bruteForce;

public class Main {

    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final int ALPHABET_SIZE = ALPHABET.length();

    public static void main(String[] Argv) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите режим работы (шифрование/дешифрование): ");
        String mode = scanner.nextLine();

        System.out.print("Введите адрес файла для чтения: ");
        String inputFile = scanner.nextLine();

        System.out.print("Введите адрес файла для записи: ");
        String outputFile = scanner.nextLine();

        System.out.print("Введите ключ(число): ");
        int key = scanner.nextInt();

        try {
            CezarCipher cipher = new CezarCipher();
            if (!fileExists(inputFile)) {
                throw new FileNotFoundException("Файл не найден: " + inputFile);
            }
            if (!cipher.isValidKey(key, ALPHABET_SIZE))
                throw new IllegalArgumentException("Ключ должен быть в диапазоне от 1 до " + (ALPHABET_SIZE - 1));

            if (mode.equalsIgnoreCase("шифрование")) {
                encryptFile(inputFile, outputFile, key, ALPHABET, ALPHABET_SIZE);
            } else if (mode.equalsIgnoreCase("дешифрование")) {
                decryptFile(inputFile, outputFile, key, ALPHABET, ALPHABET_SIZE);
            } else if (mode.equalsIgnoreCase("Взлом brute force")) {
                bruteForce(inputFile, outputFile, ALPHABET, ALPHABET_SIZE);
            } else {
                throw new IllegalArgumentException("Неверный режим работы: " + mode);
            }

            System.out.println("Файл успешно обработан");

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}