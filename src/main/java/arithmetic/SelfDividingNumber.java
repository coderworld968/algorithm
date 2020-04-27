package arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数不允许包含 0 。
 */
public class SelfDividingNumber {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int num = i;
            boolean isSdnum = true;
            do {
                int n = num % 10;
                if (n == 0 || i % n != 0) {
                    isSdnum = false;
                    break;
                }
                num = num /10;
            } while (num != 0);
            if (isSdnum) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(10, 22));
    }
}
