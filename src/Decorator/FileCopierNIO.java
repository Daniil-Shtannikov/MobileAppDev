package Decorator;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileCopierNIO {
    public static void copyFile(String sourceFilePath, String destinationFilePath) throws IOException {
        Path sourcePath = Paths.get(sourceFilePath);
        Path destinationPath = Paths.get(destinationFilePath);

        try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
             FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);

        } catch (IOException e) {
            throw new IOException("Ошибка при копировании файла: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь у исходному файлу: ");
        String sourceFilePath = scanner.next();
        System.out.println("Введите путь к конечному файлу: ");
        String destinationFilePath= scanner.next();

        try {
            copyFile(sourceFilePath, destinationFilePath);
            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}
