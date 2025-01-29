package Singleton_Enum;

public class Translator {

    public static String getSeasonName(Season season) {
        switch (season) {
            case WINTER:
                return "Зима";
            case SPRING:
                return "Весна";
            case SUMMER:
                return "Лето";
            case AUTUMN:
                return "Осень";
            default:
                throw new IllegalArgumentException("Неизвестный сезон!");
        }
    }
}
