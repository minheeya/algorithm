package book;

import java.util.Scanner;

public class NotTwoMath {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(), h = sc.nextInt();

        // 수학적인 방법 사용
        /*
          0 1 2 3 4
        0 o o x x o
        1 o o x x o
        2 x x o o x
        3 x x o o x
        -> 다음과 같이 4개의 o로 이루어진 칸과 x로 이루어진 칸이 반복됨
        --------------------------------------------------------------
        -> 행과 열을 한 줄 씩 건너뛰어 선택한 칸들을 이어 붙이면 이웃한 칸 끼리는 같이 O가 올 수 없음
        -> 그 중 o개수는 최대 칸의 수의 절반 (칸의 수가 홀수 일 경우 올림)
        --------------------------------------------------------------
        -> 행과 열을 한 줄 씩 건너뛰어 선택한 칸들을 이어 붙이는 경우의 수는 총4가지
        -> 행: (0, 2), (1, 3) * 열 (0, 2, 4), (2, 3) = 행 2가지 * 열 2가지 = 총 4가지
        --------------------------------------------------------------
        결론: 각 4가지 경우의 수에서 동그라미 최대 개수를 구해서 더하면 전체 최대 동그라미 개수를 얻을 수 있음
        */

        int[] wSelCnts = { w / 2, (w + 1) / 2 };
        int[] hSelCnts = { h / 2, (h + 1) / 2};

        int circleCnt = 0;
        for (int wSelCnt: wSelCnts) {
            for (int hSelCnt : hSelCnts) {
                // 각 케이스에서 최대 O의 개수 = 칸의 개수 절반 = (칸의 개수 + 1) / 2
                circleCnt += ((wSelCnt * hSelCnt) + 1) / 2;
            }
        }


        System.out.println("'O'의 최대 개수: " +  circleCnt);

    }

}
