package baseball.domain;

import java.util.*;

import static baseball.constants.BaseBallConstant.*;


public class Player {

    private int number;

    public Player(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    public List<Integer> splitNumber() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
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

    private void isThreeDigits(String number) {
//        if(number.matches(".{3}")) {
        if (!(number.length() == NUMBER_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    private void containsSameNumber(String number) {
//      if(number.matches(".*(\\d).*\\1.*");
        Set<String> set = new HashSet<>();
        String[] digits = number.split("");
        for (String digit : digits) {
            if (set.contains(digit)) {
                throw new IllegalArgumentException();
            }
            set.add(digit);
        }
    }

    private void containsZero(String number) {
//      if (number.matches(".*0.*") {
        if (number.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void isNumberic(String number) {
//        if (number.matches("\\d+"){
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}