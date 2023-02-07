package book;

import java.util.Arrays;

/*
* 최단거리 구하기 메모화재귀
* */
public class ExmpDp2 {

    static int w = 5, h = 4;
    static int[][] memo = new int[w + 1][h + 1];

    public static int MemoRecursion (int noww, int nowh) {

        if (noww > w || nowh > h)   return 0;
        else if (memo[noww][nowh] != 0)  return memo[noww][nowh];

        return memo[noww][nowh] = MemoRecursion(noww + 1, nowh) + MemoRecursion(noww, nowh + 1);
    }


    public static void main(String[] args) {

        memo[5][4] = 1;

        System.out.println("최단 경로의 수 :  " + MemoRecursion(0,0));
    }

}
