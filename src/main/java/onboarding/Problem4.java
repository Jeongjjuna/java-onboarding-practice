package onboarding;

import net.bytebuddy.pool.TypePool;

public class Problem4 {
    /*
    1. 기능
    반대 사전단어로 나오는 기능

    2. 예외사항
    길이가 1 ~1000인지
    */
    private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    private static final int INDEX_SIZE = 25;


    public static String solution(String word) {
        // 길이가 1 ~ 1000인지
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalStateException();
        }

        StringBuffer ans = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            String result = reverse(String.valueOf(a));
            ans.append(result);
        }

        return ans.toString();
    }



    public static String reverse(String input) {
        if (ALPHA.contains(input)) { // 대문자인 경우
            int index = ALPHA.indexOf(input);
            char reverse = ALPHA.charAt(INDEX_SIZE-index);
            return String.valueOf(reverse);
        }

        if (alpha.contains(input)) { // 소문자인 경우
            int index = alpha.indexOf(input);
            char reverse = alpha.charAt(INDEX_SIZE-index);
            return String.valueOf(reverse);
        }

        if (input.equals(" ")) {
            return " ";
        }

        // 알파벳 이외 문자는 반환하지 않음
        return "";
    }
}
