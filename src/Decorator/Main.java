package Decorator;

import java.io.*;
import java.nio.*;
import java.text.ParseException;
import java.util.Scanner;


interface TextProcessor {
    String process(String text);
}

class SimpleTextProcessor implements TextProcessor {
    @Override
    public String process(String text) {
        return text;
    }
}

abstract class TextProcessorDecorator implements TextProcessor {
    protected TextProcessor textProcessor;

    public TextProcessorDecorator(TextProcessor textProcessor) {
        this.textProcessor = textProcessor;
    }

    @Override
    public String process(String text) {
        return textProcessor.process(text);
    }
}

class UpperCaseDecorator extends TextProcessorDecorator {
    public UpperCaseDecorator(TextProcessor textProcessor) {
        super(textProcessor);
    }

    @Override
    public String process(String text) {
        return super.process(text).toUpperCase();
    }
}

class TrimDecorator extends TextProcessorDecorator {
    public TrimDecorator(TextProcessor textProcessor) {
        super(textProcessor);
    }

    @Override
    public String process(String text) {
        return super.process(text).trim();
    }
}

class ReplaceDecorator extends TextProcessorDecorator {
    public ReplaceDecorator(TextProcessor textProcessor) {
        super(textProcessor);
    }

    @Override
    public String process(String text) {
        return super.process(text).replace(" ", "_");
    }
}

public class Main {

    public static void main(String[] Argv) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи: ");
        int TaskNum = scanner.nextInt();
        switch (TaskNum) {
            case 1:
                System.out.println("Введите путь у исходному файлу: ");
                String inputFilePath = scanner.next();
                System.out.println("Введите путь к конечному файлу: ");
                String outputFilePath= scanner.next();

                try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String upperCaseLine = line.toUpperCase();
                        writer.write(upperCaseLine);
                        writer.newLine();
                    }
                    System.err.println("Файл переписан");
                } catch (FileNotFoundException e) {
                    System.err.println("Файл не найден: " + e.getMessage());
                } catch (IOException e) {
                    System.err.println("Ошибка ввода-вывода: " + e.getMessage());

                }
                break;

            case 2:
                TextProcessor processor = new ReplaceDecorator(
                new TrimDecorator(
                    new UpperCaseDecorator(
                        new SimpleTextProcessor()
                        )
                    )
                );
                String result = processor.process("       Пример текста с пробелами  ");
                System.out.println(result);
                break;
        }
    }
}
