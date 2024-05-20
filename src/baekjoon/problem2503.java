package baekjoon;

import java.util.Scanner;
import java.util.Arrays;

public class problem2503 {

    static boolean[] visited;

    static int n;

    static String[][] caseArr;

    static int answer = 0;

    public static void main(String[] args) {
        
        // 1 ~ 9 숫자 사용 가능 여부
        visited = new boolean[10];
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
        }


        // input scan
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());

        caseArr = new String[n][3];
        for (int i = 0; i < n; i++) {
            caseArr[i]  = sc.nextLine().split(" ");

            // 3스트라이크인 경우 해당 숫자가 정답이므로 바로 출력 후 return
            if ( "3".equals(caseArr[i][1]) ) {
                System.out.println(1);
                return;
            }

            // 0스트라이크 0볼 인 경우 해당 숫자는 사용 가능 여부 false로 변경
            if ( !"00".equals(caseArr[i][1] + caseArr[i][2]) )   continue;

            String caseNum = caseArr[i][0];
            for (int j = 0; j < 3; j++) {
                visited[caseNum.charAt(j) - '0'] = false;
            }

        }

        searchAnswer("");

        // output
        System.out.println(answer);

        return;
    }

    public static void searchAnswer(String num) {

        if (num.length() == 3) {
            if (isAnswer(num)) answer++;
            return;
        }


        for (int i = 1; i < 10; i++) {

            if (!visited[i]) continue;

            String nextNum = num + Integer.toString(i);

            visited[i] = false;
            searchAnswer(nextNum);
            visited[i] = true;

        }

    }

    public static boolean isAnswer(String num) {

        for (int i = 0; i < n; i++) {

            String caseNumber       = caseArr[i][0];

            int strike  = 0;
            int ball    = 0;
            for (int j = 0; j < 3; j++) {

                int equalIdx = caseNumber.indexOf(num.charAt(j));

                if (equalIdx == -1)   continue;

                if (equalIdx == j)  strike++;
                else                ball++;

            }

            if (Integer.parseInt(caseArr[i][1]) != strike)  return false;
            if (Integer.parseInt(caseArr[i][2]) != ball)    return false;

        }

        return true;
    }
}
