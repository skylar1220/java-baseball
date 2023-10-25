# 기능 목록

## domain
### Player
1. 입력받은 수를 갖고있다.
2. 입력받은 수에 대한 유효성을 검증한다.

## view
### InputView
1. 입력 메소드를 실행해 입력값을 받는다.

### OutputView
1. 출력 메소드를 실행해 화면을 출력한다.

## controller
1. 게임을 시작한다.
2. 정답을 맞추면 진행할지 여부에 따라 진행한다.

# 전체 흐름

1. 프로그램 시작
   (BaseballController) - OutputView.printStart() 메서드 호출하여 시작 메시지 출력

2. 게임 초기화

   (BaseballController) - 랜덤한 세 자리 숫자 생성

   (BaseballController) - Game.init() 메서드 호출하여 게임 초기화

3. 게임 진행 (반복)

   3.1. 사용자 입력 받기
   (BaseballController) - InputView.getPlayer() 메서드 호출하여 사용자로부터 숫자 입력 받음

   (Player 클래스)     - 입력한 숫자는 Player 객체로 생성되고, 유효성 검사를 수행

   3.2. 입력한 숫자와 랜덤한 숫자 비교 (Game.compareNumbers() 메서드 내부)

   3.2.1. 스트라이크(strike) 및 볼(ball) 카운트 초기화

   (Player 클래스) - int strikeCount = 0; // 스트라이크 개수 초기화

   (Player 클래스) - int ballCount = 0;   // 볼 개수 초기화

       3.2.2. 입력한 숫자와 랜덤한 숫자 비교
              (Player 클래스) - 사용자가 입력한 숫자를 가져옴: Player 객체의 splitNumber() 메서드 호출
              (BaseballController) - 랜덤한 숫자를 가져옴: 미리 생성된 랜덤한 세 자리 숫자

       3.2.3. 비교 로직 수행
              (BaseballController) - 입력한 숫자의 각 자릿수와 랜덤한 숫자의 각 자릿수를 비교
              (BaseballController) - 자릿수와 값이 같으면 스트라이크 증가
              (BaseballController) - 값은 같지만 자릿수가 다르면 볼 증가

       3.2.4. 스트라이크와 볼 카운트 반환
              (BaseballController) - 결과를 반환하여 출력에 사용

   3.3. 결과 출력
   (BaseballController) - OutputView.printStrikeBall() 또는 OutputView.printNothing() 메서드 호출하여 결과 출력

   3.4. 게임 종료 여부 확인

   (BaseballController) - 스트라이크가 3개인 경우 (Game.isGameOver() 메서드 호출)

   (BaseballController) - 게임 종료 시 OutputView.printCorrect() 메서드 호출하여 정답 메시지 출력

   3.5. 사용자에게 게임 진행 여부 묻기

   (BaseballController) - InputView.getContinous() 메서드 호출하여 사용자에게 게임 진행 여부 입력 받음

4. 게임 종료
    - 프로그램 종료
