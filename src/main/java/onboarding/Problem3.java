package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

/*
시뮬레이션해보자

1.기능
i번째가 손벽치는 횟수 구하기

 */
public class Problem3 {
    public static int solution(int number) {
        IntStream numbers = IntStream.rangeClosed(1, number);
        return numbers
                .map(Problem3::getNumber)
                .sum();
    }

    private static int getNumber(int number) {
        int cnt = 0;
        String num = Integer.toString(number);
        for (int idx = 0; idx < num.length(); idx++) {
            if (isSame369(num, idx)) cnt += 1;
        }
        return cnt;
    }

    private static boolean isSame369(String num, int idx) {
        return num.charAt(idx) == '3' || num.charAt(idx) == '6' ||num.charAt(idx) == '9';
    }
}
