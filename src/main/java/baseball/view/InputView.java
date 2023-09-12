package baseball.view;

import static baseball.constants.BaseBallConstant.*;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Player getPlayer() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String number = Console.readLine();
        return new Player(number);
    }

    public static int getContinous() {
        System.out.println(CONTINOUS_MESSAGE);
        int continous = Integer.parseInt(Console.readLine());
        return continous;
    }
}
