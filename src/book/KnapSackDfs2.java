package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KnapSackDfs2 {

    static int  n;
    static int maxWeight;
    static int maxVal;

    static int[]    weights;
    static int[]    vals;

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

        // dfs
        searchMaxValue(0, 0, 0);

        // answer
        System.out.println("MaxValues is " + maxVal);

    }

    public static void searchMaxValue(int culN, int sumWeight, int sumVal) {

        // [재귀 종료조건1] 최대 무게의 범위를 넘어 갈 경우
        if (sumWeight > maxWeight) return;

        // 최대 가치 업데이트
        maxVal = Math.max(maxVal, sumVal);

        // [재귀 종료조건2] 물건의 범위를 넘어 갈 경우
        if ( culN >= n ) return;

        searchMaxValue(culN + 1, sumWeight, sumVal); // 물건을 넣지 않는다
        searchMaxValue(culN + 1, sumWeight + weights[culN], sumVal + vals[culN]); // 물건을 넣는다

    }

}
