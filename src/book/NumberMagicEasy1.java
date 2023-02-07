package book;

import java.util.Scanner;

public class NumberMagicEasy1 {

    public static void main(String[] args) {

        int[] card1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] card2 = {1, 2, 3, 4, 9, 10, 11, 12};
        int[] card3 = {1, 2, 5, 6, 9, 10, 13, 14};
        int[] card4 = {1, 3, 5, 7, 9, 11, 13, 15};

        Scanner sc      = new Scanner(System.in);
        String  answer  = sc.next();

        for (int i = 1; i <= 16; i++) {
            if (check(card1, i) != answer.charAt(0))    continue;
            if (check(card2, i) != answer.charAt(1))    continue;
            if (check(card3, i) != answer.charAt(2))    continue;
            if (check(card4, i) != answer.charAt(3))    continue;

            System.out.println("MagicNumber : " + i);
        }

    }

    public static char check(int[] card, int targetNum) {

        for (int n: card) {
            if (n == targetNum) return 'Y';
        }
        return 'N';
    }
}
