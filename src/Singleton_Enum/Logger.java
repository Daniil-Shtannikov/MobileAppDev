package Singleton_Enum;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;

    private List<String> logs;

    private Logger() {
        logs = new ArrayList<>();
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logs.add(message);
    }

    public void printLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
}