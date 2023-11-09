package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 3스트라이크", "7, 8, 9, 낫싱"})
    void compare(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));

        assertThat(actual).isEqualTo(expected);
    }


    @Test
    void 스트라이크_3번() {
//        Referee referee = new Referee();
        String result = referee.compare(ANSWER, Arrays.asList(1, 2, 3));

        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 낫싱() {
        String result = referee.compare(ANSWER, Arrays.asList(7, 8, 9));

        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void 볼_3번() {
        String result = referee.compare(ANSWER, Arrays.asList(2, 3, 1));

        assertThat(result).isEqualTo("3볼");
    }

    @Test
    void 볼_1번_스트라이크_2번() {
        String result = referee.compare(ANSWER, Arrays.asList(1, 3, 7));

        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

}