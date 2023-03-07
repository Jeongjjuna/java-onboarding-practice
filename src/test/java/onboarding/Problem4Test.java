package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class Problem4Test {

    @DisplayName("반대로 나오는지 확인")
    @ParameterizedTest
    @MethodSource("reverseResult")
    void reverseTest(String input, String expected) {
        // given

        // when
        String result = Problem4.reverse(input);

        // then
        assertThat(result).isEqualTo(expected);

    }

    private static Stream<Arguments> reverseResult() {
        return Stream.of(
                arguments("a","z"),
                arguments("z","a"),
                arguments("A","Z"),
                arguments("Z","A"),
                arguments("m","n"),
                arguments("M","N"),
                arguments(" "," ")
        );
    }

    @Test
    void solutionTest() {
        // given
        String input = "I love you";

        // when
        String result = Problem4.solution(input);

        // then
        assertThat(result).isEqualTo("R olev blf");
    }
}