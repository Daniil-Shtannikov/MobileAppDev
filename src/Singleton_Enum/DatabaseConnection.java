package Singleton_Enum;

public class DatabaseConnection {
    // Статическая переменная для хранения единственного экземпляра
    private static DatabaseConnection instance;

    // Приватный конструктор для предотвращения создания экземпляров извне
    private DatabaseConnection() {
        // Инициализация подключения к базе данных
        System.out.println("Создано подключение к базе данных.");
    }

    // Публичный метод для получения единственного экземпляра
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
