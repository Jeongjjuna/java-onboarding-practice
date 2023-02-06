package onboarding;

import java.util.List;

/*
1. 예외사항
    책은(번호가 반드시 있어야함)
    책은(1~400페이지)
    펼쳤을 때 왼쪽 오른쪽이 1페이지 차이여야함
    책은(왼쪽 홀수, 오른쪽 짝수)

2. 기능
두사람 점수 비교해서 결과리턴

한 사람의 점수 계산
    왼쪽 페이지 계산
        더했을 때 계산
        곱했을 떄 계산
    오른쪽 페이지 계산
        더했을 때 계산
        곱했을 때 계산

 */
class Problem1 {
    private static final int POBI_WIN_NUMBER = 1;
    private static final int CRONG_WIN_NUMBER = 2;
    private static final int DRAW_NUMBER = 0;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!isContainTwoNumber(pobi, crong)) return EXCEPTION;
        if (!isRange(pobi, crong)) return EXCEPTION;
        if (!isDiffOne(pobi, crong)) return EXCEPTION;
        if (!isOddAndEven(pobi, crong)) return EXCEPTION;

        int pobiNumber = calculateMaxScore(pobi);
        int crongNumber = calculateMaxScore(crong);

        if (pobiNumber > crongNumber) return POBI_WIN_NUMBER;
        if (crongNumber > pobiNumber) return CRONG_WIN_NUMBER;
        return DRAW_NUMBER;
    }

    private static boolean isContainTwoNumber(List<Integer> pobi, List<Integer> crong) {
        return (pobi.size() == 2 && crong.size() == 2);
    }

    private static boolean isRange(List<Integer> pobi, List<Integer> crong) {
        boolean result1 = pobi.stream().allMatch( num -> num < 401 && num > 0);
        boolean result2 = crong.stream().allMatch( num -> num < 401 && num > 0);
        return result1 && result2;
    }

    private static boolean isDiffOne(List<Integer> pobi, List<Integer> crong) {
        boolean result1 =  pobi.get(1) - pobi.get(0) == 1;
        boolean result2 = crong.get(1) - crong.get(0) == 1;
        return result1 && result2;
    }

    private static boolean isOddAndEven(List<Integer> pobi, List<Integer> crong) {
        boolean result1 =  (pobi.get(0) + pobi.get(1)) % 2 == 1;
        boolean result2 = (crong.get(0) + crong.get(1)) % 2 == 1;
        return result1 && result2;
    }

    private static int calculateMaxScore(List<Integer> pages) {
        int leftPageMaxScore = calculatePage(pages.get(0));
        int rightPageMaxScore = calculatePage(pages.get(1));
        return Math.max(leftPageMaxScore, rightPageMaxScore);
    }

    private static int calculatePage(int page) {
        int maxsScoreWhenMultiple = multiplePage(page);
        int maxScoreWhenAdd = addPage(page);
        return Math.max(maxsScoreWhenMultiple, maxScoreWhenAdd);
    }

    private static int multiplePage(int page) {
        int multiplied = 1;
        String digitPages = String.valueOf(page);
        for (int i = 0; i < digitPages.length(); i++) {
            multiplied *= digitPages.charAt(i) - '0';
        }
        return multiplied;
    }

    private static int addPage(int page) {
        int added = 0;
        String digitPages = String.valueOf(page);
        for (int i = 0; i < digitPages.length(); i++) {
            added += digitPages.charAt(i) - '0';
        }
        return added;
    }
}