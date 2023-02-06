package onboarding;

import java.util.*;

import static org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils.toCharArray;

public class Problem2 {
    /*
    1.예외사항

    2.기능
    중복제거기능
    중복이있는지확인

     */
    public static String solution(String cryptogram) {
        String afterRemoveDuplicate = cryptogram;;
        String beforeRemoveDuplicate;
        do {
            beforeRemoveDuplicate = afterRemoveDuplicate;
            afterRemoveDuplicate = removeDuplicate(beforeRemoveDuplicate);
        } while(afterRemoveDuplicate.length() != beforeRemoveDuplicate.length());
        return afterRemoveDuplicate;
    }

    private static String removeDuplicate(String crypyogram) {
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

        return String.valueOf(toCharArray(stack));
    }
}
