package cn.algorithms.part02;

/**
 * 删除链表中给定的值
 *
 * @author TaoistQu
 */
public class DeleteGivenValue {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static Node removeValue(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            //确保头部不是要删除的节点
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void printNode(Node head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node next = head;
        Node newNode = null;
        for (int i = 1; i <= 10; i++) {
            newNode = new Node(i);
            next.next = newNode;
            next = newNode;
        }
        printNode(head);
        System.out.println("====================================");
        Node node = removeValue(head, 0);
        printNode(node);

    }
}
