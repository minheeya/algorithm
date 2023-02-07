package book;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class KnapsackDfs {

    static int  n;
    static int maxWeight;
    static int maxVal;

    static ArrayList<Integer> knapsackIn = new ArrayList<>();

    static int[]    weights;
    static int[]    vals;

    static boolean[] visited;

    public static void main(String[] args) {

        // input
        Scanner sc = new Scanner(System.in);

        maxWeight   = sc.nextInt();
        n           = sc.nextInt();

        weights = new int[n];
        for (int i = 0; i < n; i++) {   weights[i] = sc.nextInt();   }

        vals = new int[n];
        for (int i = 0; i < n; i++) {   vals[i] = sc.nextInt();  }

        visited = new boolean[n];
        System.out.println("maxWeight : " + maxWeight);
        System.out.println("n : " + n);
        System.out.println("weight : " + Arrays.toString(weights));
        System.out.println("vals : " + Arrays.toString(vals));

        // dfs start
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            searchMaxValue(weights[i], vals[i]);
            visited[i] = false;
        }

        // return answer
        System.out.println("Max Value is " + maxVal);
        System.out.println("knapsackIn is " + knapsackIn);

    }

    public static void searchMaxValue(int sumWeight, int sumVal) {

        System.out.println("visited " + Arrays.toString(visited));


        // dfs exit condition
        if (sumWeight > maxWeight) return;

        // update maxVal
        maxVal = Math.max(maxVal, sumVal);

        // update knapsackIn
        if (sumVal == maxVal) {
            knapsackIn.clear();
            for (int i = 0; i < n; i++) if(visited[i])  knapsackIn.add(i);
        }

        // put
        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            visited[i] = true;
            searchMaxValue(sumWeight + weights[i], sumVal + vals[i]);
            visited[i] = false;
        }

    }

}
