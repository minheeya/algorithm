package book;

import java.util.Arrays;
import java.util.Scanner;

public class CorporationSalary {

    static int      n;
    static String[] relations;
    static int[]    salaries;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        relations = new String[n];
        salaries = new int[n];

        for (int i = 0; i < n; i++) {   relations[i] = sc.next();   }

        System.out.println("직원 수: " + n);
        System.out.println("relations : " + Arrays.toString(relations));


        // 각 직원 별 급여의 합 return
        int sumSalary = 0;
        for (int i = 0; i < n; i++) {   sumSalary += getSalary(i);   }

        System.out.println("직원 별 급여 : " + Arrays.toString(salaries));
        System.out.println("직원의 급여 합산 : " + sumSalary);

    }

    public static int getSalary(int personNum) {

        if (salaries[personNum] != 0) return salaries[personNum];

        String relation = relations[personNum];

        for (int j = 0; j < n; j++) {

            if (relation.charAt(j) == 'N')  continue;
            salaries[personNum] += getSalary(j);
        }

        if (salaries[personNum] == 0) salaries[personNum] = 1;

        return salaries[personNum];
    }
}
