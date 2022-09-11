package book;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class MiroPoint {
    int x, y, order;
    MiroPoint(int x, int y, int order) { this.x = x; this.y = y; this.order = order; }
}

public class Miro {

    static int N, M;
    static int m;
    static int cntOrder = 0;
    static char[][] maze;
    static int[] moveRow;
    static int[] moveCol;
    static Queue<MiroPoint> q = new LinkedList<>();

    public static void main(String args[]) {

        // load input values
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int dotCnt  = 0;
        maze        = new char[N][M];
        for (int i = 0; i < N; i++) {
            String st = sc.next();

            for (int j = 0; j < M; j++) {
                char ch = st.charAt(j);
                if (ch == '.')  dotCnt++;
                maze[i][j] = ch;
            }
        }

        int startRow = sc.nextInt();
        int startCol = sc.nextInt();
        maze[startRow][startCol] = 'X';
        cntOrder++;
        q.add(new MiroPoint(startRow, startCol, 0));

        m   = sc.nextInt();
        moveRow = new int[m];
        for (int i = 0; i < m; i++) {
            moveRow[i] = sc.nextInt();
        }

        moveCol = new int[m];
        for (int i = 0; i < m; i++) {
            moveCol[i] = sc.nextInt();
        }

        // start searchMiro
        int maxOrder = 0;
        while (!q.isEmpty()) {
            MiroPoint cul = q.poll();
            searchMiro(cul.x, cul.y, cul.order);
            maxOrder = Math.max(maxOrder, cul.order);
        }

        // return answer
        int answer;
        if (dotCnt != cntOrder)     answer = -1;
        else                        answer = maxOrder;
        System.out.println("answer :: " + answer);
    }

    public static void searchMiro(int x, int y, int order) {

        for (int i = 0; i < m; i++) {
            int nx = x + moveRow[i], ny = y + moveCol[i];

            if ((nx < 0) || (nx >= N) || (ny < 0) || (ny >= M) || maze[nx][ny] == 'X') continue;

            maze[nx][ny] = 'X';
            cntOrder++;
            q.add(new MiroPoint(nx, ny, order + 1));
        }
    }
}
