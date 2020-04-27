package arithmetic;


import java.util.Arrays;

public class KmpMain {

    public static void main(String args[]) {
        String str = "DABABCABABCABDB";
//        System.out.println(Arrays.toString(getNext("abcdabd")));
        System.out.println(Arrays.toString(getNext("ABCABD".toCharArray())));
        System.out.println(kmSearch(str, "ABCABD"));

        String p = "ABCABD";
        int[] next = new int[6];
        getNextval(p.toCharArray(), next);
        System.out.println(Arrays.toString(next));

    }

    private static int kmSearch(String source, String target) {
        int i = 0;
        int j = 0;
        int sLen = source.length();
        int pLen = target.length();
        char[] s = source.toCharArray();
        char[] p = target.toCharArray();
        int[] next = getNext(source.toCharArray());
        System.out.println("next:" + Arrays.toString(next));
        while (i < sLen && j < pLen) {
            //如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                //如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] getNext(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < p.length - 1) {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
            System.out.println("in-next:" + Arrays.toString(next));
        }
        return next;
    }

    /* P 为模式串，下标从 0 开始 */
    static void getNextval(char[] P, int nextval[]) {
        int p_len = P.length;
        int i = 0;   // P 的下标
        int j = -1;
        nextval[0] = -1;

        while (i < p_len-1) {
            if (j == -1 || P[i] == P[j]) {
                i++;
                j++;

                if (P[i] != P[j])
                    nextval[i] = j;
                else
                    nextval[i] = nextval[j];  // 既然相同就继续往前找真前缀
            } else
                j = nextval[j];
        }
    }

}
