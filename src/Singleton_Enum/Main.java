package Singleton_Enum;

import java.util.Scanner;
import static Singleton_Enum.Translator.getSeasonName;

enum Status{
    NEW,
    IN_PROGRESS,
    DELIVERED,
    CANCELLED
}

enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}


public class Main {
    public static void main(String[] Argv) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи: ");
        int TaskNum = scanner.nextInt();
        switch(TaskNum){

            case 1:
                DatabaseConnection db1 = DatabaseConnection.getInstance();
                DatabaseConnection db2 = DatabaseConnection.getInstance();
                System.out.println(db1 == db2);
                break;

            case 2:
              Logger logger1 = Logger.getInstance();
              Logger logger2 = Logger.getInstance();
              System.out.println(logger1 == logger2);

              logger1.log("Первое сообщение");
              logger2.log("Второе сообщение");
              logger1.printLogs();
              break;

            case 3:
                Order order = new Order();
                System.out.println("Текущий статус заказа: " + order.getStatus());
                try {
                order.setStatus(Status.IN_PROGRESS);
                System.out.println("Текущий статус заказа: " + order.getStatus());

                order.setStatus(Status.CANCELLED);
                System.out.println("Текущий статус заказа: " + order.getStatus());

                order.setStatus(Status.DELIVERED);
                System.out.println("Текущий статус заказа: " + order.getStatus());


                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                Season season = Season.WINTER;
                Season season2 = Season.SUMMER;
                String seasonName = getSeasonName(season);
                String seasonName2 = getSeasonName(season2);
                System.out.println("Сезоны: " + seasonName + ", " + seasonName2);
                break;
        }
    }
}
