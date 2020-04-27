package arithmetic;

/**
 * 删除给定单向链表的倒数第N个元素
 */
public class DeleteKFromEnd {
    static ListNode deleteKFromEnd(ListNode head, int n) {
        ListNode quickListNode = head;
        ListNode slowListNode = null;
        int count = 0;
        while (quickListNode != null) {
            if (slowListNode == null && count == n) {
                // 快指针已经移动过N个元素之后,慢指针才会指向链表头元素
                slowListNode = head;
            } else if (slowListNode != null) {
                // 慢指针后移
                slowListNode = slowListNode.next;
            }
            // 快指针后移
            quickListNode = quickListNode.next;
            // 计数,用于判断慢指针开始指向头元素时机
            // 以及,链表边界值问题
            count++;
            if (quickListNode == null) {
                break;
            }
        }
        if (count == n) {
            // 删除元素正好是边界值时,返回链表第一个元素做为新链表首元素
            return head;
        } else {
            return slowListNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println((listNode1));
        ListNode backward = deleteKFromEnd(listNode1, 5);
        System.out.println(backward);
    }


    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return "Node{data=" + val + ", next=" + next + '}';
        }
    }
}
