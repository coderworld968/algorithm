package arithmetic;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 首 尾 双指针
 */
public class ExchangeArrayOddEven {
    static int[] exchange(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (array[i] % 2 == 1 && i < j) {
                // 奇数,指针后移
                i++;
            }
            while (array[j] % 2 == 0 && i < j) {
                // 偶数,指针前移
                j--;
            }

            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1,2,3,4,5,6})));
        System.out.println(Arrays.toString(exchange(new int[]{1,2,3,3,5,6})));
    }
}
