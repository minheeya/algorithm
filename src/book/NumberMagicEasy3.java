package book;

import java.util.Scanner;

public class NumberMagicEasy3 {

    public static void main(String[] args) {

        String[] nAnswer = {"YYYY",
                            "YYYN",
                            "YYNN",
                            "YYNN",
                            "YNYY",
                            "YNYN",
                            "YNNY",
                            "YNNN",
                            "NYYY",
                            "NYYN",
                            "NYNY",
                            "NYNN",
                            "NNYY",
                            "NNYN",
                            "NNNY",
                            "NNNN"};

        Scanner sc      = new Scanner(System.in);
        String  answer  = sc.next();

        for (int n = 1; n <= 16; n++) {
            if (answer.equals(nAnswer[n - 1])) {
                System.out.println("MagicNumber : " + n);
                return;
            }
        }

        return;
    }

}
