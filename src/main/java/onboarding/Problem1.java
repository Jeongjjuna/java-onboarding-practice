package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int SumPageNum(int pageNumber) {
        int ret = 0;
        char c;
        String pageNumberStr = Integer.toString(pageNumber);

        for (int i = 0; i < pageNumberStr.length(); i++) {
            c = pageNumberStr.charAt(i);
            ret += Character.getNumericValue(c);
        }

        return ret;
    }

    public static int mulPageNum(int pageNumber) {
        int ret = 1;
        char c;
        String pageNumberStr = Integer.toString(pageNumber);

        for (int i = 0; i < pageNumberStr.length(); i++) {
            c = pageNumberStr.charAt(i);
            ret *= Character.getNumericValue(c);
        }

        return ret;
    }

    public static int getMaxNum(int leftPage, int rightPage) {
        // page정수 4개를 넣을 arrList선언
        ArrayList<Integer> arrList = new ArrayList<>();

        // 좌측 페이지합, 좌측 페이지곱, 우측 페이지합, 우측 페이지곱
        arrList.add(SumPageNum(leftPage));
        arrList.add(SumPageNum(rightPage));
        arrList.add(mulPageNum(leftPage));
        arrList.add(mulPageNum(rightPage));

        //arrList의 4개의 값중 최대값 구해서 반환
        int ret = 0;
        for (int i = 0; i < arrList.size(); i++) {
            if (ret < arrList.get((i))) {
                ret = arrList.get(i);
            }
        }

        return ret;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 포비, 크롱 좌우 페이지 넘버 가져오기
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        int pobiMaxNum = getMaxNum(pobiLeftPage, pobiRightPage);
        int crongMaxNum = getMaxNum(crongLeftPage, crongRightPage);


        return 0;
    }
}