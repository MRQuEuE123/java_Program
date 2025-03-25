import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            recursiveMethod();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError пойман!");
        }
        try {
            List<int[]> list = new ArrayList<>();
            // Бесконечный цикл для постоянного выделения памяти
            while (true) {
                // Выделяем массив, занимающий достаточно места в памяти
                list.add(new int[1024 * 1024]);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError пойман!");
        }
    }

    public static void recursiveMethod() {
        // Рекурсивный вызов без условия остановки
        recursiveMethod();
    }
}
