package arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求一个数组中和为指定值的2个元素下标
 */
public class Sum2numInArray {

    public static void main(String[] args) {
        int[] num = new int[]{42, 41, 31, 7, 17, 2, 55, 26, 80, 27};
        int target = 57;
        System.out.println("下标是:" + Arrays.toString(sum2Num(num, target)));
    }

    public static int[] sum2Num(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            Integer n = nums[i];
            Integer otherNum = target - n;
            if (map.containsKey(otherNum)) {
                // bingo
                return new int[]{i, map.get(otherNum)};
            }
            map.put(n, i);
        }
        return new int[]{};
    }
}
