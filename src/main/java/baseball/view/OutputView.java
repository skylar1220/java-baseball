package baseball.view;

import static baseball.constants.BaseBallConstant.*;

import baseball.domain.GameResult;

public class OutputView {

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printCorrect() {
        System.out.println(CORRECT_MESSAGE);
    }

    public static void printStrikeBall(int ballCount, int strikeCount) {
        if (!(ballCount == 0)) {
            System.out.print(ballCount + GameResult.BALL.getValue());
        }
        if (!(strikeCount == 0)) {
            System.out.print(strikeCount + GameResult.STRIKE.getValue());
        }
        System.out.println();
    }

    public static void printNothing() {
        System.out.println(GameResult.NOTHING.getValue());
    }
}
