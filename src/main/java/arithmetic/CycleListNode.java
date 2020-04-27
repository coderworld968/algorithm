package arithmetic;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 1.是否有环
 * hash 记录
 * 快慢双指针
 * 2.环的交点位置,链表开始入环的第一个节点。
 * 快慢指针相交点A,与头结点,同时同速遍历,相交点即为入环位置
 */
public class CycleListNode {

    /**
     * 快慢指针
     */
    public static boolean hasCycleByPoint(ListNode head) {
        boolean hasCycle = true;
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        do {
            if (fastIndex == null) {
                hasCycle = false;
                break;
            }
            if (fastIndex.next == null) {
                hasCycle = false;
                break;
            }
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
        } while (fastIndex != slowIndex);
        return hasCycle;
    }

    /**
     * 环形相加点
     * F:头结点到入环结点距离
     * B:入环结点到快慢指针相交结点距离
     * C:快慢指针相交结点到入环结点距离
     * 2*慢指针移动距离=快指针移动距离
     * 2(F+B)=F+B+B+C
     * F = C
     *
     * @param head
     * @return
     */
    static ListNode getEntranceNode(ListNode head) {
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        do {
            if (fastIndex == null) {
                break;
            }
            if (fastIndex.next == null) {
                fastIndex = fastIndex.next;
                break;
            }
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
        } while (fastIndex != slowIndex);
        if (fastIndex == null) {
            return null;
        }
        ListNode headIndex = head;
        while (fastIndex != headIndex) {
            fastIndex = fastIndex.next;
            headIndex = headIndex.next;
        }
        return fastIndex;
    }

    /**
     * hash
     * 开辟新空间
     */
    public static boolean hasCycleByHash(ListNode head) {
        boolean hasCycle = false;
        Set set = new HashSet();
        while (head != null) {
            if (set.contains(head)) {
                hasCycle = true;
                break;
            }
            set.add(head);
            head = head.next;
        }
        return hasCycle;
    }


    /**
     * 标记法
     * 修改原本值,不推荐
     */
    private boolean traverseMarkSolution(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.val == 0xcafebabe) {
            return true;
        }
        head.val = 0xcafebabe;
        return traverseMarkSolution(head.next);
    }


    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        Assert.assertTrue(hasCycleByPoint(n1));
        Assert.assertEquals(2, getEntranceNode(n1).val);
    }

    private static void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Assert.assertFalse(hasCycleByPoint(n1));
        Assert.assertNull(getEntranceNode(n1));
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
    }
}
