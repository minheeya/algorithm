package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;


public class RicochetRobotBfs {

    static int len, width;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public int solution(String[] board) {

        len     = board.length;
        width   = board[0].length();


        // 방문 위치 초기화
        visited = new boolean[len][width];


        // 시작점, 목표지점 세팅
        int startX  = 0, startY = 0;
        for (int i = 0; i < len; i++) {
            startX = i;
            startY = board[i].indexOf("R");

            if (startY != -1) break;
        }

        visited[startX][startY] = true;
        q.add(new int[] {startX, startY, 0});
        int answer = bfs(board);

        return answer;
    }

    public int bfs(String[] board) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        while (!q.isEmpty()) {

            int[] culArr = q.poll();
            int culX = culArr[0], culY = culArr[1], culCnt = culArr[2];

            // 목표지점에 도착한 경우
            if (board[culX].charAt(culY) == 'G') return culCnt;


            // 상, 하, 좌, 우 이동
            for (int i = 0; i < 4; i++) {

                int nx = culX, ny = culY;

                int n = 1;
                while (true) {

                    nx = culX + dx[i] * n;
                    ny = culY + dy[i] * n;

                    // 범위를 벗어나거나 D를 만난경우
                    if ( (nx < 0) || (nx >= len) || (ny < 0) || (ny >= width) )   break;
                    if (board[nx].charAt(ny) == 'D')    break;

                    n++;
                }

                // 범위를 벗어나거나 D를 만난경우 이전위치가 다음위치
                n--;
                nx = culX + dx[i] * n;
                ny = culY + dy[i] * n;


                // 이전에 방문한 위치는 다시 방문하지 않음
                if (visited[nx][ny])   continue;


                visited[nx][ny] = true;
                q.add(new int[] {nx, ny, culCnt + 1});

            }

        }

        return -1;
    }
}