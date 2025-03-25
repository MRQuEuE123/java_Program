import java.util.Scanner;

public enum DayOfWeek {
    MONDAY("MON", false),
    TUESDAY("TUE", false),
    WEDNESDAY("WED", false),
    THURSDAY("THU", false),
    FRIDAY("FRI", false),
    SATURDAY("SAT", true),
    SUNDAY("SUN", true);
    private final String abbreviation;
    private final boolean isWeekend;


    // Конструктор
    DayOfWeek(String abbreviation, boolean isWeekend) {
        this.abbreviation = abbreviation;
        this.isWeekend = isWeekend;

    }

    public static DayOfWeek fromNumber(int number) {
        if (number < 1 || number > 7) {
            throw new IllegalArgumentException("Invalid day number: " + number);
        }
        return values()[number - 1]; // Преобразуем 1-7 в индекс 0-6
    }

    // Метод для отображения информации о дне недели
    public void displayInfo() {
        String weekendStatus = isWeekend ? "is a weekend." : "is not a weekend.";
        System.out.println(this.name() + " (" + abbreviation + ") " + weekendStatus);
    }

    @Override
    public String toString() {
        String weekendStatus = isWeekend ? "is a weekend." : "is not a weekend.";
        return this.name() + " (" + abbreviation + ") " + weekendStatus;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        System.out.println("Пожалуйста, введите число для преобразования :");
        input = scanner.nextInt();
        if(input>=8 || input<=0) System.out.println(input);
        else {
            DayOfWeek day = DayOfWeek.fromNumber(input);
            System.out.println(day);
        }

        System.out.println("\nПеречисление всех дней");
        // Пример использования
        for (DayOfWeek days : DayOfWeek.values()) {
            days.displayInfo();
        }
    }
}
