package programmers;

public class RicochetRobotDfs {

    static int len, width;
    static int startX, startY;
    static int goalX, goalY;

    static int[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] board) {

        len   = board.length;
        width = board[0].length();


        // 시작점, 도착점
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i].charAt(j) == 'R') {startX = i; startY = j;}
                if (board[i].charAt(j) == 'G') {goalX  = i; goalY  = j;}
            }
        }


        // 방문 기록 -1으로 초기화
        visited = new int[len][width];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                visited[i][j] = -1;
            }
        }


        // 탐색
        visited[startX][startY] = 0;
        dfs(board, startX, startY, 0);


        return visited[goalX][goalY];
    }

    public void dfs(String[] board, int x, int y, int cnt) {

        // dfs종료 조건 : 목표에 도달하는 경우
        if ( (x == goalX) && (y == goalY) ) {
            visited[goalX][goalY] = cnt;
            return;
        }


        // 상, 하, 좌, 우 이동
        for (int i = 0; i < 4; i++) {

            int nx, ny;

            int n = 1;
            while (true) {

                nx = x + dx[i] * n;
                ny = y + dy[i] * n;

                if ((nx < 0) || (nx >= len) || (ny < 0) || (ny >= width))   break;
                if (board[nx].charAt(ny) == 'D')  break;

                n++;
            }

            // 범위를 넘어가거나 D를 만났을 경우 이전위치가 다음위치
            n--;
            nx = x + dx[i] * n;
            ny = y + dy[i] * n;


            // 방문하지 않았거나, 해당 위치에서 최소경로로 방문하지 않은 경우 이동
            if ( (visited[nx][ny] == -1) || (visited[nx][ny] > (cnt + 1)) ) {
                visited[nx][ny] = cnt + 1;
                dfs(board, nx, ny, cnt + 1);
            }

        }

        return;
    }

}
