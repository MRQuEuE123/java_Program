import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    static class TextEditor {

        private StringBuilder text;

        TextEditor(String text) {
            this.text = new StringBuilder(text);
        }

        public void append(String additionalText) {
            text.append(additionalText);
        }

        public void insert(int position, String newText) {
            text.insert(position, newText);
        }

        public void removeCharacter(char c) {
            int index;
            while ((index = text.indexOf(String.valueOf(c))) != -1) {
                text.deleteCharAt(index);
            }
        }

        public void replaceSubString(String oldSub, String newSub) {
            int index;
            while ((index = text.indexOf(oldSub)) != -1) {
                text.replace(index, index + oldSub.length(), newSub);
            }

        }

        @Override
        public String toString() {
            return text.toString();
        }



    }

    public static  String reverse(String str){
        char [] newstr = new char[str.length()];
        for(int i=str.length()-1; i>=0;i--) {
            newstr[str.length()-i-1] = str.charAt(i);
        }
        return new String(newstr);
    }


    public static  void inout(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите строку для переворота:\n");
            String input = scanner.nextLine();
            String reversed = reverse(input);
            System.out.println("Перевернутая строка: " + reversed);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static  void ioDeleteSpaces(){
        Scanner scanner = new Scanner(System.in);
        try  {
            System.out.println("Введите строку чтобы убрать пробелы :\n");
            String input = scanner.nextLine();
            String deleted = removeCharacter(input,' ');
            System.out.println("Удалены все пробелы : " + deleted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String removeCharacter(String str, char charToRemove) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != charToRemove) {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
    public static  void ioDeleteABC(){
        Scanner scanner = new Scanner(System.in);
        try  {
            System.out.println("Введите строку чтобы убрать Все маленькие символы :\n");
            String input = scanner.nextLine();
            String deleted = removeLowercaseLetters(input);
            System.out.println("Удалены все маленькие буквы: " + deleted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String removeLowercaseLetters(String str) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                newStr.append(ch);
            }
        }
        return newStr.toString();
    }


    public static void main(String[] args) {
        // Test Case 1
        TextEditor editor1 = new TextEditor("Погиб поэт! — невольник чести —\n" +
                "Пал, оклеветанный молвой,\nС свинцом");
        editor1.append(" в груди и жаждой мести.\n");
        System.out.println(editor1);

        // Test Case 2
        TextEditor editor2 = new TextEditor("вынесла душа поэта\n" +
                "Позора мелочных обид\n");
        editor2.insert(0, "Не ");
        System.out.println(editor2);

        // Test Case 3
        TextEditor editor3 = new TextEditor("Один, как прежде… и убит!\n" +
                "Убит!.. К чему теперь рыданья\n");
        editor3.removeCharacter('!');
        System.out.println(editor3);

        // Test Case 4
        TextEditor editor4 = new TextEditor("Один, как прежде… и убит!\n" +
                "Убит!.. К чему теперь рыданья");
        editor4.replaceSubString("убит", "programmer");
        System.out.println(editor4);

        /*inout();
        ioDeleteSpaces();
        ioDeleteABC();
         */

        Scanner scanner = new Scanner(System.in);
        String input;

        exemple_j();
        foo(scanner);


        while (true) {
            // Запрос ввода строки
            System.out.println(ANSI_BLUE + "Пожалуйста, введите строку для преобразования (или 'exit' для выхода):" + ANSI_RESET);
            input = scanner.nextLine();

            // Проверка на выход
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Преобразования
            String outputReverse = reverse(input);
            String outputRemoveChar = removeCharacter(input, ' ');
            String outputRemoveLowercase = removeLowercaseLetters(input);
            String outputEvenCharacter = evenCharacter(input);

            // Вывод результатов с цветами
            System.out.println("Перевёрнутая строка: " + ANSI_GREEN + outputReverse + ANSI_RESET);
            System.out.println("Строка после удаления пробелов: " + ANSI_YELLOW + outputRemoveChar + ANSI_RESET);
            System.out.println("Строка после удаления строчных букв: " + ANSI_RED + outputRemoveLowercase + ANSI_RESET);
            System.out.println("Строка после удаления нечетных букв: " + ANSI_RED + outputEvenCharacter + ANSI_RESET);
        }


        // Закрытие сканера
        scanner.close();





    }

    private static void exemple_j() {
        String  str1="Java",
                str2="JAVA",
                str3="C#",
                str4="Java";
        // Вывод строк
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);
        // Сравнение строк с использованием equals()
        System.out.println("equals():");
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // false
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // false
        System.out.println("str1.equals(str4): " + str1.equals(str4)); // true
        System.out.println("str2.equals(str3): " + str2.equals(str3)); // false
        System.out.println("str2.equals(str4): " + str2.equals(str4)); // false
        System.out.println("str3.equals(str4): " + str3.equals(str4)); // false

        // Сравнение с использованием equalsIgnoreCase()
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2)); // true

        // Сравнение с использованием оператора ==
        System.out.println("str1 == str4: " + (str1 == str4)); // true

        // Изменение str1 и сравнение подстроки
        str1 = "JavaJava";
        System.out.println("str1.substring(4) == str4: " + (str1.substring(4) == str4)); // false

        // Сравнение str1 с null
        System.out.println("str1 == null: " + (str1 == null)); // false

        // Присваивание str1 значения null и сравнение
        str1 = null;
        System.out.println("str1 == null: " + (str1 == null)); // true
    }

    private static void foo(Scanner scanner) {
        System.out.println("Введите количество элементов в массиве:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Инициализация массива
        String[] array = new String[n];

        // Ввод элементов массива
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            array[i] = input.isEmpty() ? null : input;
        }

        // Замена пустых строк и null на "String is empty"
        for (int i = 0; i < n; i++) {
            array[i] = (array[i] == null || array[i].isEmpty()) ? "String is empty" : array[i];
        }

        // Вывод результата
        System.out.println("Отредактированный массив:");
        for (String str : array) {
            System.out.println(str);
        }
    }

    private static String evenCharacter(String input) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < input.length(); i+=2) {
            char ch = input.charAt(i);
            newStr.append(ch);

        }
        return newStr.toString().toUpperCase();
    }


}