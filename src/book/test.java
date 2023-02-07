package book;



public class test {

    static int[] ws = {3, 4, 1, 2, 3};
    static int[] ps = {2, 3, 2, 3, 6};
    static int maxw = 10;

    static int KnapSack(int n, int w) {

        if (w > maxw)   return -1;
        if (n >= 5)     return 0;
        return Math.max(KnapSack(n + 1, w), KnapSack(n + 1, w + ws[n]) + ps[n]);
    }

    public static void main(String[] args) {
        System.out.println(KnapSack(0, 0));
    }

}
