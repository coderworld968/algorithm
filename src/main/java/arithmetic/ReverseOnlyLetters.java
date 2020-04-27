package arithmetic;

import org.junit.Assert;

/**
 * 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转
 */
public class ReverseOnlyLetters {

    static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            while (start < end && !(Character.isUpperCase(chars[start]) || Character.isLowerCase(chars[start]))) {
                start++;
            }
            while (start < end && !(Character.isUpperCase(chars[end]) || Character.isLowerCase(chars[end]))) {
                end--;
            }
            if (start < end) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start ++;
                end --;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        Assert.assertEquals("dc-ba",reverseOnlyLetters("ab-cd"));
        Assert.assertEquals("dc-ba",reverseOnlyLetters("ab-cd"));
        Assert.assertEquals("j-Ih-gfE-dCba",reverseOnlyLetters("a-bC-dEf-ghIj"));
        Assert.assertEquals("Qedo1ct-eeLg=ntse-T!",reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
