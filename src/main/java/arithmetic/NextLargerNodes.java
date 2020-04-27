package arithmetic;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 找出一个单向链表中,找出每个节点之后的下个较大值,如果不存在则返回0
 */
public class NextLargerNodes {

    static int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        // 1. 创建一个容器 list 来存储数据
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        // 2. 创建一个栈 stack ，这个栈里面存储的是对应位置的 list 元素及其之后元素中最大的值。
        int size = list.size();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[size];
        // 3. 在 list 中从右往左遍历，stack 中凡是比 list.get(i) 小的都 pop 出去，
        // 这样 stack 剩下的元素都是比 list.get(i) 更大的元素。
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            result[i] = stack.empty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(2).nextNode(new ListNode(1).nextNode(new ListNode(5)));
        Assert.assertArrayEquals(new int[]{5, 5, 0}, nextLargerNodes(ln));
        // [2,7,4,3,5]
        ListNode ln2 = new ListNode(2).nextNode(new ListNode(7).nextNode(
                new ListNode(4).nextNode(new ListNode(3).nextNode(new ListNode(5)))));
        Assert.assertArrayEquals(new int[]{7, 0, 5, 5, 0}, nextLargerNodes(ln2));

        //[1,7,5,1,9,2,5,1]
        //[7,9,9,9,0,5,0,0]
        ListNode ln3 = new ListNode(1).nextNode(new ListNode(7).nextNode(
                new ListNode(5).nextNode(new ListNode(1).nextNode(new ListNode(9)
                        .nextNode(new ListNode(2)
                                .nextNode(new ListNode(5).nextNode(new ListNode(1))))))));
        Assert.assertArrayEquals(new int[]{7, 9, 9, 9, 0, 5, 0, 0}, nextLargerNodes(ln3));

        //[6,4,5,2,8,2,5,1]
        //[8,5,8,8,0,5,0,0]
        ListNode node = new ListNode(6).nextNode(new ListNode(4).nextNode(
                new ListNode(5).nextNode(new ListNode(2).nextNode(new ListNode(8)
                        .nextNode(new ListNode(2)
                                .nextNode(new ListNode(5).nextNode(new ListNode(1))))))));
        Assert.assertArrayEquals(new int[]{8, 5, 8, 8, 0, 5, 0, 0}, nextLargerNodes(node));


    }


    static class ListNode {

        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
        }

        public ListNode nextNode(ListNode node) {
            this.next = node;
            return this;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
