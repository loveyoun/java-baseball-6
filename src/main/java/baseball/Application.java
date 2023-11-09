package baseball;

import baseball.domain.NumberGenerator;
import baseball.domain.Referee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    // 1. 기능을 가지고 있는 클래스를 인스턴스화(=객체) 한다.
    // 2. 필요한 기능을 역할에 맞는 인스턴스가 수행하게 한다. (의인화. 책임. 협력)
    // 3. 각 결과를 종합한다. (프로그램 동작)

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberGenerator generator = new NumberGenerator();
        List<Integer> computer = generator.createRandomNumbers();

        Referee referee = new Referee();

        String result = "";
        while (!result.equals("3스트라이크")) {
            result = referee.compare(computer, askNumbers());
            System.out.println(result);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> askNumbers() {
        System.out.println("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split("")) {
            numbers.add(Integer.valueOf(number));
        }

        return numbers;
    }

}
