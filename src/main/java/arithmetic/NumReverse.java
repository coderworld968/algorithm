package arithmetic;


/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class NumReverse {

    public static void main(String[] args) {
//        2^31-1=2147483647,-2^31=-2147483648
        System.out.println(-3 % 10);
        System.out.println(Integer.MAX_VALUE + 11);
        try {
            String s = "3147483647";
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int i = 2147483643;
        System.out.println(reverse2(1223));
        System.out.println(reverse2(-123));
        System.out.println(reverse(i));
    }

    static int reverse2(int x) {
        String s = null;
        if (x >= 0) {
            StringBuilder sb = new StringBuilder(20).append(x);
            s = sb.reverse().toString();
        } else {
            StringBuilder sb = new StringBuilder(20).append(x * -1);
            s = "-" + sb.reverse().toString();
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    static int reverse(int num) {
        int res = 0;
        while (num != 0) {
            int temp = num % 10 + res * 10;
            // 判断越界
            if ((temp - num % 10) / 10 != res) { //最关键的一步
                return 0;
            }
            res = temp;
            num /= 10;
        }
        return res;
    }
}
