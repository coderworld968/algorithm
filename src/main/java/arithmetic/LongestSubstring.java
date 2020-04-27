package arithmetic;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 。
 * 滑动窗口
 */
public class LongestSubstring {

    static String stringOfLongestSubstring(String string) {
        int start = 0;
        char[] chars = string.toCharArray();
        String lastString = "";
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer existCharIndex = map.get(c);
            if (null != existCharIndex && existCharIndex >= start) {
                // 长度比较
                String tmp = string.substring(start, i);
                if (tmp.length() > lastString.length()) {
                    lastString = tmp;
                }
                // 窗口起始位置移动到重复字符的下一位
                start = existCharIndex + 1;
                map.put(c, i);
            } else {
                map.put(c, i);
                sb.append(c);
            }
        }
        String tmp = string.substring(start);
        if (tmp.length() > lastString.length()) {
            lastString = tmp;
        }
        return lastString;
    }

    static int lengthOfLongestSubstring(String string) {
        int start = 0;
        char[] chars = string.toCharArray();
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer existCharIndex = map.get(c);
            if (null != existCharIndex && existCharIndex >= start) {
                // 长度比较
                length = Math.max((i - start), length);
                // 窗口起始位置移动到重复字符的下一位
                start = existCharIndex + 1;
                map.put(c, i);
            } else {
                map.put(c, i);
                sb.append(c);
            }
        }
        length = Math.max((string.length() - start), length);
        return length;
    }

    public static void main(String[] args) {
        Assert.assertEquals("abc", stringOfLongestSubstring("abcabcbb"));
        Assert.assertEquals("b", stringOfLongestSubstring("bbbbb"));
        Assert.assertEquals("wke", stringOfLongestSubstring("pwwkew"));
        Assert.assertEquals("kewabc", stringOfLongestSubstring("pwwkewabc"));
    }
}
