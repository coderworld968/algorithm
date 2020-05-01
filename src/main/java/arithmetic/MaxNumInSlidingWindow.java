package arithmetic;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import org.junit.Assert;


public class MaxNumInSlidingWindow {

    public static int[] getMaxNumInSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || length < k) {
            return new int[]{};
        }
        int[] result = new int[length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            int data = nums[i];
            while (!deque.isEmpty() && data >= deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(data);
            System.out.println(Arrays.toString(deque.toArray()));
        }
        System.out.println(Arrays.toString(deque.toArray()));
        int j = 0;
        for (int i = k - 1; i < length; i++) {
            int data = nums[i];
            if (i - k >= 0 && deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && data > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(data);
            System.out.println(Arrays.toString(deque.toArray()));
            result[j++] = deque.peekFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        Assert.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7},
                getMaxNumInSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        Assert.assertArrayEquals(new int[]{7, 4},
                getMaxNumInSlidingWindow(new int[]{7, 2, 4}, 2));
        Assert.assertArrayEquals(new int[]{7, 4, 5, 5},
                getMaxNumInSlidingWindow(new int[]{7, 2, 4, 5, 1}, 2));
    }
}
