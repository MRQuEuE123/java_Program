import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static boolean isBalanced(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');
        bracketMap.put('>', '<');

        for (char c : input.toCharArray()) {
            // Если символ — открывающая скобка
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                stack.push(c);
            }
            // Если символ — закрывающая скобка
            else if (c == ')' || c == ']' || c == '}' || c == '>') {
                if (stack.isEmpty() || stack.pop() != bracketMap.get(c)) {
                    return false;
                }
            }
            // Остальные символы игнорируем
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        System.out.println(isBalanced(input));
        scanner.close();
    }
}