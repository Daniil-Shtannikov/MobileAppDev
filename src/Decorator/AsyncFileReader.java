package Decorator;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


public class AsyncFileReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу: ");
        String filePath= scanner.next();
        Path path = Paths.get(filePath);

        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if (result == -1) {
                        System.out.println("Чтение файла завершено.");
                        return;
                    }

                    attachment.flip();
                    byte[] bytes = new byte[attachment.remaining()];
                    attachment.get(bytes);
                    System.out.print(new String(bytes));
                    attachment.clear();

                    fileChannel.read(attachment, 0, attachment, this);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.err.println("Ошибка при чтении файла: " + exc.getMessage());
                }
            });

            // Главный поток должен ждать завершения асинхронной операции
            Thread.sleep(5000); // Задержка для демонстрации асинхронного чтения
        } catch (IOException | InterruptedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
