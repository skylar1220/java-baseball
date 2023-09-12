package baseball.domain;

import java.util.*;

public class Player {
    private int number;

    public Player(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    public List<Integer> splitNumber() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int firstDigit = number % 10;
            digits.add(firstDigit);
            number /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }


    private void validateNumber(String number) {
        isThreeDigits(number);
        containsSameNumber(number);
        containsZero(number);
        isNumberic(number);
    }

    private void containsZero(String number) {
        if (number.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void containsSameNumber(String number) {
        Set<String> set = new HashSet<>();
        String[] digits = number.split("");
        for (String digit : digits) {
            if (set.contains(digit)) {
                throw new IllegalArgumentException();
            }
            set.add(digit);
        }
    }

    private void isThreeDigits(String number) {
        if (!(number.length() == 3)) {
            throw new IllegalArgumentException();
        }
    }

    private void isNumberic(String number) {
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}