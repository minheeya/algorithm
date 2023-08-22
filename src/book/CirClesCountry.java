package book;

import java.util.Scanner;
import java.util.ArrayList;

public class CirClesCountry {

    public static void main(String[] args) {

        // input
        Scanner sc = new Scanner(System.in);

        String[] xArr = sc.nextLine().split("\\s");
        String[] yArr = sc.nextLine().split("\\s");
        String[] rArr = sc.nextLine().split("\\s");

        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt();

        int minbndryCnt = 0;
        for (int i = 0; i < xArr.length; i++) {

            int circleX = Integer.parseInt(xArr[i]), circleY = Integer.parseInt(yArr[i]), circleR = Integer.parseInt(rArr[i]);

            // x1, y1에 대해 내부 외부 판단
            boolean startIsCircleIn = isCircleIn(circleX, circleY, circleR, x1, y1);

            // x2, y2에 대해 내부 외부 판단
            boolean endIsCircleIn = isCircleIn(circleX, circleY, circleR, x2, y2);

            // startIsCircleIn, endIsCircleIn 다를 경우 경계선을 지남
            if (startIsCircleIn != endIsCircleIn)   minbndryCnt += 1;

        }


        System.out.println("Min Circle Boundary Count is " + minbndryCnt);
    }


    public static boolean isCircleIn(int circleX, int circleY, int circleR, int x, int y) {
        return (Math.pow(circleX - x, 2) + Math.pow(circleY - y, 2)) < Math.pow(circleR, 2);
    }

}
