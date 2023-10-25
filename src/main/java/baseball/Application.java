package baseball;

import baseball.controller.BaseballController;
import baseball.db.DB;

public class Application {
    public static void main(String[] args) {
        new BaseballController().start();
    }
}
