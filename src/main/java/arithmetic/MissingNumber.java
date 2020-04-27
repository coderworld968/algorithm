package arithmetic;

import org.junit.Assert;

/**
 * 查找递增连续数组中缺失的数字
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Assert.assertEquals(5, missingNumber(new int[]{0, 1, 2, 3, 4,  6, 7}));
        Assert.assertEquals(2, missingNumber(new int[]{0, 1,}));
        Assert.assertEquals(0, missingNumber(new int[]{1, 2}));
        Assert.assertEquals(1, missingNumber(new int[]{0,}));
        Assert.assertEquals(1, missingNumber(new int[]{0, 2}));
        Assert.assertEquals(1, missingNumber(new int[]{0, 2, 3}));
        Assert.assertEquals(2, missingNumber(new int[]{0, 1, 3}));
        Assert.assertEquals(8, missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }
}
