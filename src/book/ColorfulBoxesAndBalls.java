package book;

import java.util.Scanner;

public class ColorfulBoxesAndBalls {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numRed = sc.nextInt(), numBlue = sc.nextInt();
        int onlyRed = sc.nextInt(), onlyBlue = sc.nextInt(), bothColors = sc.nextInt();


        int numChange   = Math.min(numRed, numBlue);  // 빨간색, 파란색 바꿔서 상자에 넣을 수 있는 공의 수

        // 기본 점수로 초기화
        // 빨간색 상자 - 빨간색 공, 파란색 상자 - 파란색 공 점수
        int maxScore    = (numRed * onlyRed) + (numBlue * onlyBlue);
        int culScore    = (numRed * onlyRed) + (numBlue * onlyBlue);

        // 빨간색, 파란색 바꿔서 상자에 넣는 경우를 탐색
        for (int i = 0; i < numChange; i++) {
            culScore = culScore - onlyRed - onlyBlue + (bothColors * 2);
            maxScore = Math.max(maxScore, culScore);
        }


        System.out.println("MaxScore is " + maxScore);
    }

}
