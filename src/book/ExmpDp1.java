package book;

/*
* 최단거리 구하기 dfs 사용
* */

public class ExmpDp1 {

    static final int w = 5, h = 4;

    public static int dfs(int noww, int nowh) {

        if (noww > w || nowh > h)   return 0;
        if (noww == w && nowh == h) return 1;

        return dfs(noww + 1, nowh) + dfs(noww, nowh + 1);
    }

    public static void main(String[] args) {

        System.out.println("최단 경로의 수 :  " + dfs(0,0));

    }

}
