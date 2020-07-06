package arithmetic;

import org.junit.Assert;

// 二维有序数组中,数字查找
// 横向递增
// 纵向递增
public class FindInSortedMatrix {

    static boolean find(int[][] nums, int rows, int columns, int number) {
        boolean found = false;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (nums[row][column] == number) {
                found = true;
                break;
            } else if (nums[row][column] > number) {
                --column;
            } else {
                ++row;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3, 10, 12}, {2, 5, 11, 15}, {4, 8, 12, 16}, {6, 9, 13, 18}};
        Assert.assertEquals(true, find(nums, 4, 4, 8));
        Assert.assertEquals(true, find(nums, 4, 4, 18));
        Assert.assertEquals(false, find(nums, 4, 4, 100));
        Assert.assertEquals(false, find(nums, 4, 4, -1));
    }
}
