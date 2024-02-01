import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите выражение: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        calc(input);
    }

    public static void calc(String input) throws IOException {
        String[] signs = {"+", "-", "/", "*"};
        String[] checkSigns = {"\\+", "-", "/", "\\*"};
        int signsIndex = -1;
        for (int i = 0; i < signs.length; i++) {
            if (input.contains(signs[i])) {
                signsIndex = i;
                break;
            }
        }

        if (signsIndex == -1) {
            throw new IOException("Строка не является математической операцией!");
        }

        String[] data = input.split(checkSigns[signsIndex]);
        if (!(data.length == 2)) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }

        int a, b;

        a = Integer.parseInt(data[0]);
        b = Integer.parseInt(data[1]);
        if (a > 10 || a < 1 || b > 10 || b < 1) {
            throw new IOException("На вход принимаются числа от 1 до 10 включительно");

        }

        int result = switch (signs[signsIndex]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };

        System.out.println(result);
    }
}