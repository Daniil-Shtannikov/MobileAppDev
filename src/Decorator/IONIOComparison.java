package Decorator;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class IONIOComparison {
    public static void copyFileUsingIO(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    public static void copyFileUsingNIO(String inputFilePath, String outputFilePath) {
        Path inputPath = Paths.get(inputFilePath);
        Path outputPath = Paths.get(outputFilePath);

        try (FileChannel inputChannel = FileChannel.open(inputPath, StandardOpenOption.READ);
             FileChannel outputChannel = FileChannel.open(outputPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inputChannel.read(buffer) > 0) {
                buffer.flip();
                outputChannel.write(buffer);
                buffer.clear();
            }

        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\User\\Desktop\\qa.txt";
        String outputFilePathIO = "C:\\Users\\User\\Desktop\\sa.txt";
        String outputFilePathNIO = "C:\\Users\\User\\Desktop\\ra.txt";

        long startTimeIO = System.currentTimeMillis();
        copyFileUsingIO(inputFilePath, outputFilePathIO);
        long endTimeIO = System.currentTimeMillis();
        System.out.println("Время выполнения IO: " + (endTimeIO - startTimeIO) + " ms");

        long startTimeNIO = System.currentTimeMillis();
        copyFileUsingNIO(inputFilePath, outputFilePathNIO);
        long endTimeNIO = System.currentTimeMillis();
        System.out.println("Время выполнения NIO: " + (endTimeNIO - startTimeNIO) + " ms");
    }
}
