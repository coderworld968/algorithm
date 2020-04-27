package arithmetic;


public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static long climbStairs2(long n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        long n2 = 1;//n-2
        long n1 = 2;//n-1
        long nn = 0;
        for (int i = 3; i <= n; i++) {
            nn = n1 + n2;
            n2 = n1;
            n1 = nn;
        }
        return nn;
    }


    public static long fib(long n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        long n2 = 0;//n-2
        long n1 = 1;//n-1
        long nn = 0;
        for (int i = 2; i <= n; i++) {
            nn = n1 + n2;
            n2 = n1;
            n1 = nn;
        }
        return nn;
    }




    public static void main(String[] args) {
        System.out.println(climbStairs2(3));
        System.out.println(climbStairs2(4));
        System.out.println(climbStairs2(12));
        long x100 = climbStairs2(20);
        long x101 = climbStairs2(21);
        System.out.println(x100 + "," + x101);
        System.out.println(((double)x100)/((double)x101));
    }
}
