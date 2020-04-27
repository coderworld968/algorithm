package arithmetic;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Sum2NumLinkedlist {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        // 642
        Node num1 = new Node(2).nextNode(new Node(4).nextNode(new Node(6)));
        // 465
        Node num2 = new Node(5).nextNode(new Node(6).nextNode(new Node(4)));
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(add(num1, num2));
    }

    private static void test1() {
        // 342
        Node num1 = new Node(2).nextNode(new Node(4).nextNode(new Node(3)));
        // 465
        Node num2 = new Node(5).nextNode(new Node(6).nextNode(new Node(4)));
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(add(num1, num2));
    }

    static Node add(Node head1, Node head2) {
        Node n1 = head1;
        Node n2 = head2;
        Node result = null;
        Node nr = null;
        int carry = 0;
        while (!(n1 == null && n2 == null)) {
            int num1 = 0;
            int num2 = 0;
            if (n1 != null) {
                num1 = n1.data;
                n1 = n1.next;
            }
            if (n2 != null) {
                num2 = n2.data;
                n2 = n2.next;
            }
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            int d = sum % 10;
            if (null == result) {
                result = new Node(d);
                nr = result;
            } else {
                nr.nextNode(new Node(d));
                nr = nr.next;
            }
        }
        if (carry != 0) {
            nr.nextNode(new Node(carry));
        }
        return result;
    }


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node nextNode(Node node) {
            this.next = node;
            return this;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
