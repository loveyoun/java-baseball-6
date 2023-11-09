package baseball.domain;

import java.util.List;

public class Referee {

    public String compare(List<Integer> computer, List<Integer> player) {
        Judgement judge = new Judgement();
        int correctCount = judge.correctCount(computer, player);

        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (judge.hasPlace(computer, i, player.get(i)))
                strike++;
        }

        int ball = correctCount - strike;

        String result = "";
        if (ball != 0 && strike != 0) result = ball + "볼 " + strike + "스트라이크";
        else if (ball != 0) result = ball + "볼";
        else if (strike != 0) result = strike + "스트라이크";
        else result = "낫싱";

        return result;
    }

}
