package book;

import java.util.Arrays;
import java.util.Scanner;

public class knapSackMemo {

    static int  n;
    static int maxWeight;
    static int maxVal;

    static int[]    weights;
    static int[]    vals;

    static int[][] dp = new int[6][11];   // 0으로 초기화

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        maxWeight   = sc.nextInt();
        n           = sc.nextInt();

        weights = new int[n];
        for (int i = 0; i < n; i++) {   weights[i] = sc.nextInt();   }

        vals = new int[n];
        for (int i = 0; i < n; i++) {   vals[i] = sc.nextInt();  }

        System.out.println("maxWeight : " + maxWeight);
        System.out.println("n : " + n);
        System.out.println("weight : " + Arrays.toString(weights));
        System.out.println("vals : " + Arrays.toString(vals));

        // dfs_memo
        searchMaxValue(0, 0);

        // answer
        System.out.println("MaxValues is " + dp[0][0]);

    }

    public static int searchMaxValue(int culN, int sumWeight) {

        // [재귀종료조건1] 최대 무게의 범위를 넘어 갈 경우
        if (sumWeight > maxWeight) return Integer.MIN_VALUE;

        // [재귀종료조건2] 물건의 범위를 넘어 갈 경우
        if (culN >= n)    return 0;

        // 이미 계산한 값이 존재하는 경우
        if (dp[culN][sumWeight] > 0)    return dp[culN][sumWeight];

        return dp[culN][sumWeight] = Math.max(searchMaxValue(culN + 1, sumWeight), searchMaxValue(culN + 1, sumWeight + weights[culN]) + vals[culN]);
    }

}
