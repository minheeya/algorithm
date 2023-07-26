package book;

import java.util.Scanner;

public class NotTwoGreedy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(), h = sc.nextInt();

        int[][] board = new int[h + 2][w + 2];


        // 그리디 알고리즘 기법 사용
        // 왼쪽 위부터 오른쪽 방향으로 O을 채워나간다
        // o : 1, x: 0
        int circleCnt = 0;
        for (int i = 2; i < h + 2; i++) {
            for (int j = 2; j < w + 2; j++) {
                // 두칸 위 or 왼쪽 두칸 전 위치에 O가 존재하면 O를 써넣을 수 없음
                if (board[i - 2][j] == 1 || board[i][j - 2] == 1)   continue;

                board[i][j] = 1;
                circleCnt++;
            }
        }

        System.out.println("'O'의 최대 개수: " +  circleCnt);

    }
}
