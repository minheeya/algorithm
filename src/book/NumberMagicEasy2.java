package book;

import java.util.Scanner;

public class NumberMagicEasy2 {

    public static void main(String[] args) {

        // 카드의 정보를 문자열 배열에 저장
        String[] card = {"YYYYYYYYNNNNNNNN",
                         "YYYYNNNNYYYYNNNN",
                         "YYNNYYNNYYNNYYNN",
                         "YNYNYNYNYNYNYNYN"};

        Scanner sc      = new Scanner(System.in);
        String  answer  = sc.next();

        for (int n = 1; n <= 16; n++) {
            // 각 카드에 대한 존재여부를 문자열 temp로 표현
            String temp = "";
            for (int idx = 0; idx < 4; idx++) temp += card[idx].charAt(n - 1);

            if (answer.equals(temp)) {
                System.out.println("MagicNumber : " + n);
                return;
            }
        }

        return;
    }

}
