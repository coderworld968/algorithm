package arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角中，每个数是它左上方和右上方的数的和。
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class YangHuiSanJiao {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        result.add(list1);
        if (numRows == 1) {
            return result;
        }
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        result.add(list2);
        if (numRows == 2) {
            return result;
        }
        // n-1
        List<Integer> listnSub1 = list2;
        for (int row = 3; row <= numRows; row++) {
            List<Integer> listn = new ArrayList<>();
            listn.add(1);
            for (int j = 1; j < row - 1; j++) {
                int n = listnSub1.get(j - 1) + listnSub1.get(j);
                listn.add(n);
            }
            listn.add(1);
            listnSub1 = listn;
            result.add(listn);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(4));
        System.out.println(generate(5));
        System.out.println(generate(6));
        System.out.println(generate(7));
    }
}
