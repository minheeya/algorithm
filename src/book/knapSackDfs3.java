package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class knapSackDfs3 {

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
        maxVal = searchMaxValue(0, 0);

        // answer
        System.out.println("MaxValues is " + maxVal);

    }

    public static int searchMaxValue(int culN, int sumWeight) {

        System.out.println("(현재보고있는 번호, 현재 담고 있는 무게): " + "( " + culN + " , " + sumWeight + ") ");

        // [재귀 종료조건1] 최대 무게의 범위를 넘어 갈 경우
        if (sumWeight > maxWeight) {
            System.out.println("최대 무게를 가져 " + Integer.MIN_VALUE + "을 return 하고 종료합니다");
            return Integer.MIN_VALUE;
        }

        // [재귀 종료조건2] 물건의 범위를 넘어 갈 경우
        if (culN >= n) {
            System.out.println("물건의 범위를 넘어가서 0를 return 하고 종료합니다");
            return 0;
        }

        return Math.max(searchMaxValue(culN + 1, sumWeight), searchMaxValue(culN + 1, sumWeight + weights[culN]) + vals[culN]);

    }

}
