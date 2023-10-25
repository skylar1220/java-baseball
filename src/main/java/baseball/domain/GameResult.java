package baseball.domain;

public enum GameResult {
    STRIKE("스트라이크"), BALL("볼 "), NOTHING("낫싱");

    private String value;

    GameResult(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
