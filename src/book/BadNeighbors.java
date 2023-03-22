package book;

import java.util.Arrays;
import java.util.Scanner;

public class BadNeighbors {

    static int n;

    static int[] donations;
    static boolean[] visited;

    static int maxDonation;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        donations = new int[n];
        for (int i = 0; i < n; i++) {   donations[i] = sc.nextInt();    }

        visited = new boolean[n];

        // 탐색 시작
        dfs(0, 0);

        System.out.println("Max donation is " + maxDonation);

    }

    public static void dfs(int i, int sum) {

        if (i == n) {
            maxDonation = Math.max(maxDonation, sum);
            return;
        }


        // 이전 이웃이 기부했을 경우
        if ( ( (i >= 1) && visited[i - 1] ) || ( (i == n - 1) && visited[0]) ) {   dfs(i + 1, sum);    return; }


        // 이전 이웃이 기부하지 않았을 경우
        // 현재 기부하지 않음
        dfs(i + 1, sum);

        // 현재 기부함
        visited[i] = true;
        dfs(i + 1, sum + donations[i]);
        visited[i] = false;

        return;
    }

}
