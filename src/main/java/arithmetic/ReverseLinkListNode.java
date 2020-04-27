package arithmetic;

/**
 * 链表反转
 */
public class ReverseLinkListNode {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(print(node1));
        System.out.println(print(reverse(node1)));
//        System.out.println(print(reverse2(node1)));
    }

    /**
     * 从原链表的头部一个一个取节点并插入到新链表的头部.
     */
    static Node reverse(Node head) {
        Node nextNode = head;
        Node newNode = null;
        while (nextNode != null) {
            Node n = nextNode;
            nextNode = n.next;
            n.next = newNode;
            newNode = n;
        }
        return newNode;
    }

    /**
     * 2.每次都将原第一个结点之后的那个结点放在新的表头后面.
     */
    static Node reverse2(Node head) {
        Node nextNode = head;
        Node firstNode = null;
        while (nextNode != null) {
            Node n = nextNode;
            nextNode = n.next;
            n.next = firstNode;
            firstNode = n;
        }
        return firstNode;
    }


    static String print(Node head) {
        StringBuilder sb = new StringBuilder("Head->");
        Node p = head;
        while (p != null) {
            sb.append(p.data).append("->");
            p = p.next;
        }
        sb.append("null");
        return sb.toString();
    }


   static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
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