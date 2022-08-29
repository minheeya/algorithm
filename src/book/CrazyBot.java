package book;

import java.util.Scanner;

public class CrazyBot {

    static int n;
    static int[][]      bord;
    static boolean[][]  visited;

    static double[] movePro = new double[4];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static double sucProb;

    public static void main(String[] args) {

        // load inputs
        Scanner sc = new Scanner(System.in);
        n            = sc.nextInt();
        movePro[0]   = sc.nextInt() * 0.01;
        movePro[1]   = sc.nextInt() * 0.01;
        movePro[2]   = sc.nextInt() * 0.01;
        movePro[3]   = sc.nextInt() * 0.01;

        // create variable
        bord    = new int[(2 * n) + 1][(2 * n) + 1];
        visited = new boolean[(2 * n) + 1][(2 * n) + 1];

        visited[n][n] = true;
        run(n, n, n, 1.0);

        System.out.println("answer:: " + sucProb);
    }

    public static void run(int x, int y, int n, double culProb) {

        if (n == 0) {  // end condition of recursive
            sucProb += culProb;
            return;
        }

        for (int i = 0; i < 4; i++) {
            double nProb = movePro[i];
            int nx = x + dx[i];
            int ny = y + dy[i];

            // already visited or movePro is zero
            if (visited[nx][ny] || movePro[i] == 0) continue;

            visited[nx][ny] = true;
            run(nx, ny, n - 1, culProb * nProb);
            visited[nx][ny] = false;
        }
    }

}
