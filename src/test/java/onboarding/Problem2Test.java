package onboarding;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils.toCharArray;

public class Problem2Test {

    @DisplayName("중복을 잘 제거하는지")
    @ParameterizedTest
    @MethodSource("removeDuplResult")
    void removeDupl(String input, String result) {
        // when
        Deque<Character> b = removeDuplicate(input);
        String inputResult = String.valueOf(toCharArray(b));

        // then
        assertThat(result.equals(inputResult)).isTrue();
    }

    private static Stream<Arguments> removeDuplResult() {
        return Stream.of(
                arguments("browoanoommnaon", "browoannaon"),
                arguments("browoannaon", "browoaaon"),
                arguments("browoaaon", "browoon"),
                arguments("browoon", "brown"),
                arguments("zyelleyz", "zyeeyz"),
                arguments("zyeeyz", "zyyz"),
                arguments("zyyz", "zz"),
                arguments("zz", "")
        );
    }

    public Deque<Character> removeDuplicate(String crypyogram) {
        Deque<Character> stack = new ArrayDeque<>();
        int idx = 0;
        while (idx < crypyogram.length()) {
            stack.addLast(crypyogram.charAt(idx++));

            boolean isDuplicated = false;
            while (idx < crypyogram.length() && stack.getLast() == crypyogram.charAt(idx)) {
                idx++;
                isDuplicated = true;
            }

            if (isDuplicated) stack.removeLast();
        }
        return stack;
    }
}
