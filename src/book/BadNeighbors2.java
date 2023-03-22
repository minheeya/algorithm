package book;

import java.util.Scanner;

public class BadNeighbors2 {

    static int n;

    static int[] donations;
    static boolean[] visited;

    static int maxDonation;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        donations = new int[n];
        for (int i = 0; i < n; i++) {   donations[i] = sc.nextInt();    }

        visited = new boolean[n];


        System.out.println("Max donation is " + maxDonation);

    }

}
