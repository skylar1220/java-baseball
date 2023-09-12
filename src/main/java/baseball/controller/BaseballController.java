package baseball.controller;

import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;


public class BaseballController {

    Player player = new Player("123");
    List<Integer> computer = new ArrayList<>();
    int ballCount = 0;
    int strikeCount = 0;
    boolean isCorrect = false;

    public void start() {
        OutputView.printStart();
        play();
        processCorrect();
    }

    private void play() {
        setComputer();
        while (!isCorrect) {
            getInput();
            compareNumber();
            getOutput();
            isCorrect = checkCorrect(strikeCount);
            resetCount();
        }
    }

    private void processCorrect() {
        OutputView.printCorrect();
        int continous = InputView.getContinous();
        if (continous == 1) {
            isCorrect = false;
            computer = new ArrayList<>();
            start();
        }
    }

    private void resetCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    private boolean checkCorrect(int strikeCount) {
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    private void getOutput() {
        if(containsNothing()){
            OutputView.printNothing();
        }
        if(!containsNothing()){
            OutputView.printStrikeBall(ballCount, strikeCount);
        }
    }

    private boolean containsNothing() {
        if(ballCount == 0 && strikeCount == 0) {
            return true;
        }
        return false;
    }

    private void setComputer() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void compareNumber() {
        List<Integer> player_ = player.splitNumber();
        IntStream.range(0, 3).forEach(i -> {
            getBallCount(i, computer, player_);
            getStrikeCount(i, computer, player_);
        });
    }

    private void getStrikeCount(int index, List<Integer> computer, List<Integer> player) {
        if (checkStrike(index, computer, player)) {
            strikeCount++;
        }
    }

    private void getBallCount(int index, List<Integer> computer, List<Integer> player) {
        if (!checkStrike(index, computer, player) && checkBall(index, computer, player)) {
            ballCount++;
        }
    }

    private boolean checkStrike(int index, List<Integer> computer, List<Integer> player) {
        if (computer.get(index).equals(player.get(index))) {
            return true;
        }
        return false;
    }

    private boolean checkBall(int index, List<Integer> computer, List<Integer> player) {
        if (computer.contains(player.get(index))) {
            return true;
        }
        return false;
    }

    private void getInput() {
        player = InputView.getPlayer();
    }

}
