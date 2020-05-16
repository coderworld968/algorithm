package arithmetic;

import java.util.LinkedList;
import java.util.List;

public class Backtracking {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        backTrack(result, nums, new LinkedList<Integer>());
        return result;
    }

    //回溯
    public static void backTrack(List<List<Integer>> result, int[] nums, LinkedList<Integer> path) {
        //结束条件：组合的深度等于所以元素的数量
        if (path.size() == nums.length) {
            result.add(new LinkedList(path));
            return;
        }
        //节点选择
        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (path.contains(nums[i])) {
                continue;
            }
            // 选择
            path.add(nums[i]);
            backTrack(result, nums, path);
            //回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
