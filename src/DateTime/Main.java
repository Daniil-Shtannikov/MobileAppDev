package DateTime;

import org.jetbrains.annotations.NotNull;

import java.lang.*;
import java.text.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void CurrentDateTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Текущие дата и время: ");
        System.out.println( LocalDate.now().format(dateFormatter) + " " + LocalTime.now().format(timeFormatter));
    }

    public static void ComparingDates(Date Date1, @NotNull Date Date2) {
        int result = Date2.compareTo(Date1);

        if (result>0)
            System.out.println("Результат: Первая дата меньше");
        else if (result == 0)
            System.out.println("Результат: Даты равны");
        else
            System.out.println("Результат: Первая дата больше");

    }

    public static void DaysBeforeNewYear(){
        LocalDate currentDate = LocalDate.now();
        LocalDate newYearDate = LocalDate.of(currentDate.getYear(), 12, 31);

        if (currentDate.isAfter(newYearDate)) {
            newYearDate = newYearDate.plusYears(1);
        }
        long result = ChronoUnit.DAYS.between(currentDate, newYearDate);
        System.out.println("До Нового года: "+ result + " дней");
    }

    public static Boolean LeapYear(int year){

        if(year % 4 != 0)
            return Boolean.FALSE;
        else if (year % 100 == 0)
            if (year % 400 == 0)
                return Boolean.TRUE;
            else
                return Boolean.FALSE;
        else
            return Boolean.TRUE;
    }

    public static void DaysOffMonth(int month, int year){
        YearMonth yearMonth = YearMonth.of(year, month);
        int Count = 0;

        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
            LocalDate date = LocalDate.of(year, month, day);
            if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
                Count++;
            }
        }

        System.out.println("В месяце "+ Count + " выходных дней");
    }

    public static void MethodExecutionTime(@NotNull Runnable task){
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        System.out.println("Время выполнения: " + (endTime - startTime) + " наносекунд");
    }

    public static void DateFormattingParsing (String inputDate ){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        LocalDate newDate = date.plusDays(10);

        String formattedDate = newDate.format(outputFormatter);
        System.out.println("Новая дата: " + formattedDate);

    }

    public static void ConvertDate(String UTCDT){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");

        ZonedDateTime utcDateTime = ZonedDateTime.parse(UTCDT, formatter.withZone(ZoneId.of("UTC")));
        ZonedDateTime moscowDateTime = utcDateTime.withZoneSameInstant(ZoneId.of("Europe/Moscow"));

        System.out.println("Дата и время в Москве: " + moscowDateTime.format(formatter));
    }

    public static void CalculatingAgeDB(LocalDate birthDate){
        LocalDate currentDate = LocalDate.now();
        System.out.println("Возраст: " + Period.between(birthDate, currentDate).getYears() + " лет");

    }

    public static void CreatingMonthlyCalendar(int month, int year){
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate firstDay = yearMonth.atDay(1);
        LocalDate lastDay = yearMonth.atEndOfMonth();

        System.out.println("Календарь на " + yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + year);
        System.out.println("Пн Вт Ср Чт Пт Сб Вс");

        LocalDate date = firstDay;
        while (date.getDayOfWeek().getValue() != 1) {
            date = date.minusDays(1);
        }

        while (date.isBefore(lastDay.plusDays(1))) {
            System.out.printf("%2s ", date.getDayOfMonth());
            if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
                System.out.print(" ");
            }
            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
            date = date.plusDays(1);
        }
    }

    public static void GeneratingRandomDate(@NotNull LocalDate startDate, @NotNull LocalDate endDate) {
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
        LocalDate Date = LocalDate.ofEpochDay(randomDay);
        System.out.println("Случайная дата: " + Date);
    }

    public static void CalculatingTimeGivenDate(LocalDateTime eventDateTime) {
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(now, eventDateTime);

            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 60;

            System.out.println("Осталось времени до события: " + hours + " часов, " + minutes + " минут, " + seconds + " секунд.");
        }

    public static void CalculatingNumberWorkingHours(LocalDateTime start, LocalDateTime end) {
        long totalHours = ChronoUnit.HOURS.between(start, end);
        long workHours = 0;

        LocalDateTime current = start;
        while (current.isBefore(end)) {
            workHours++;
            current = current.plusHours(1);
        }

        System.out.println("Рабочих часов: " + workHours);
    }

    @NotNull
    public static String ConvertingDateStringBasedLocale(@NotNull LocalDate date, @NotNull Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", locale);
        return date.format(formatter);

    }

    public static void DeterminingDayOfWeek(@NotNull LocalDate date) {
        System.out.println("День недели: " + date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("ru", "RU")));

    }

    public static void main(String[] Argv) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи: ");
        int TaskNum = scanner.nextInt();
        switch(TaskNum){

            case 1:
                CurrentDateTime();
                break;

            case 2:
                System.out.println("Введите первую дату: ");
                String First = scanner.next();
                System.out.println("Введите вторую дату: ");
                String Second = scanner.next();

                SimpleDateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date date1 = DateFormat.parse(First);
                Date date2 = DateFormat.parse(Second);

                ComparingDates(date1, date2);
                break;

           case 3:
                DaysBeforeNewYear();
                break;

            case 4:
                System.out.println("Введите год: ");
                int Year = scanner.nextInt();

                if (LeapYear(Year))  System.out.println("Год високосный");
                else  System.out.println("Год невисокосный");
                break;

            case 5:
                System.out.println("Введите месяц: ");
                int month = scanner.nextInt();
                System.out.println("Введите год: ");
                int year = scanner.nextInt();

                DaysOffMonth(month, year);
                break;

            case 6:
                MethodExecutionTime(() -> {
                    int a=0;
                    for (int i = 0; i < 1_000_000; i++) {
                        a++;
                    }
                });
                break;

            case 7:
                System.out.println("Введите дату в формате день-месяц-год (19-09-2025): ");
                String inputDate = scanner.next();

                DateFormattingParsing(inputDate);
                break;

            case 8:
                String inputDateTime = "2025-01-26 14:01:00Z";
                ConvertDate(inputDateTime);
                break;

            case 9:
                LocalDate birthDate = LocalDate.of(2006, 9, 19);
                CalculatingAgeDB(birthDate);
                break;

            case 10:
                System.out.println("Введите год: ");
                int year1 = scanner.nextInt();
                System.out.println("Введите месяц числом: ");
                int month1 = scanner.nextInt();
                CreatingMonthlyCalendar(month1, year1);

                break;
            case 11:
                LocalDate startDate = LocalDate.of(2000, 1, 1);
                LocalDate endDate = LocalDate.of(2025, 1, 31);
                GeneratingRandomDate(startDate, endDate);
                GeneratingRandomDate(startDate, endDate);
                break;

            case 12:
                LocalDateTime eventDateTime = LocalDateTime.of(2025, 1, 31, 19, 0, 0);
                CalculatingTimeGivenDate(eventDateTime);
                break;


            case 13:
                LocalDateTime start = LocalDateTime.of(2025, 1, 28, 8, 30);
                LocalDateTime end = LocalDateTime.of(2025, 1, 28, 18, 20);
                CalculatingNumberWorkingHours(start, end);
                break;

            case 14:
                LocalDate date = LocalDate.of(2023, 10, 1);
                Locale ruLocale = new Locale("ru", "RU");
                Locale enLocale = Locale.ENGLISH;
                System.out.println("Дата на русском: " + ConvertingDateStringBasedLocale(date, ruLocale));
                System.out.println("Дата на английском: " + ConvertingDateStringBasedLocale(date, enLocale));
                break;
            case 15:
                LocalDate date15 = LocalDate.of(2025, 1, 28);
                DeterminingDayOfWeek(date15);
                break;

            default:

                System
                .out.println("Нет такой задачи!");
        }
    }
}