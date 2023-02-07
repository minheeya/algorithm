package book;
/*
* 최단거리 구하기 동적계획법
* */
public class ExmpDp3 {

    static int w = 5, h = 4;
    static int[][] dp = new int[w + 1][h + 1];

    public static int DynamicProgramming (int w, int h) {

        dp[0][0] = 1;

        for (int i = 0; i < w + 1; i++) {
            for (int j = 0; j < h + 1; j++) {

                if (i != 0) dp[i][j] += dp[i - 1][j];
                if (j != 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[w][h];
    }

    public static void main(String args[]) {

        System.out.println("최단 경로의 수 :  " + DynamicProgramming(5,4));

        for (int i = 0; i < w + 1; i++) {
            for (int j = 0; j < h + 1; j++) {
                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
            }
        }

    }
}
