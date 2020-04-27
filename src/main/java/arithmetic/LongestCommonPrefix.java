package arithmetic;

import org.junit.Assert;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] strs) {
        if(strs.length ==0){
            return "";
        }
        // 找出参照
        String minString = strs[0];
        int minIndex = 0;
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minString = strs[i];
                minIndex = i;
                minLength = strs[i].length();
            }
        }
        // 遍历索引位置对应char是否与参照串相同
        for (int endIndex = 0; endIndex < minString.length(); endIndex++) {
            char c = minString.charAt(endIndex);
            for (int i = 0; i < strs.length; i++) {
                if (i == minIndex) {
                    continue;
                }
                if (c != strs[i].charAt(endIndex)) {
                    return minString.substring(0, endIndex);
                }
            }
        }
        return minString;
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(0, 2));
        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

}
