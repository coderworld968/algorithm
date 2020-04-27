package arithmetic;

import org.junit.Assert;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的[最大]长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class JumpArrayEnd {
    static int jump(int[] nums) {
        int count = 0;
        int length = nums.length;
        int slowIndex = 0;
        int quickIndex = 0;
        while (quickIndex < length - 1) {
            count++;
            int nextIndex = slowIndex;
            for (int i = slowIndex; i <= quickIndex; i++) {
                if (nums[i] + i > nextIndex) {
                    nextIndex = nums[i] + i;
                }
            }
            slowIndex = quickIndex;
            quickIndex = nextIndex;
        }
        return count;
    }

    public static void main(String[] args) {
        Assert.assertEquals(2, jump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertEquals(4, jump(new int[]{2, 2, 4, 1, 5, 3, 2, 1, 1, 1, 1}));
        Assert.assertEquals(3, jump(new int[]{2, 2, 3, 1, 2, 2, 1}));
    }

}
