package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        //기본 구분자
        String delimiter = ",|:";

        //커스텀 구분자
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = matcher.group(1);
                input = matcher.group(2);
            } else {
                throw new IllegalArgumentException("잘못된 값 입력");
            }
        }

        String[] tokens = input.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            int number = toPositiveNumber(token);
            sum += number;
        }
        return sum;
    }

    private int toPositiveNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }
}
