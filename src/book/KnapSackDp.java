package book;

import java.util.Arrays;
import java.util.Scanner;

public class KnapSackDp {

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

        // dp에 값 put
        putValOnDp();

        // dp값 출력
        System.out.println(Arrays.deepToString(dp));

        // answer
        System.out.println("MaxValues is " + maxVal);

    }

    static void putValOnDp() {

        dp[0][0] = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {

                // 물건을 넣었을 때, 최대 무게를 넘는 경우
                if (j + weights[i] > maxWeight) continue;

                dp[i + 1][j + weights[i]] = Math.max(dp[i + 1][j + weights[i]], dp[i][j] + vals[i]);
                maxVal = Math.max(maxVal, dp[i + 1][j + weights[i]]);
            }
        }

    }
}
