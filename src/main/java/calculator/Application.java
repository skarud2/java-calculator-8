package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        try {
            int result = calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("에러 발생: " + e.getMessage());
        }
    }
}
