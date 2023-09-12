package baseball.view;

import static baseball.constants.BaseBallConstant.*;

public class OutputView {

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printCorrect() {
        System.out.print(CORRECT_MESSAGE);
    }

    public static void printStrikeBall(int ballCount, int strikeCount) {
        if (!(ballCount == 0)) {
            System.out.print(ballCount + "볼 ");
        }
        if (!(strikeCount == 0)) {
            System.out.print(strikeCount + "스트라이크");
        }
        System.out.println();
    }

    public static void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }
}
