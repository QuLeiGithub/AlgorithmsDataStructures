package cn.algorithms.part07;

/**
 * 用递归的方式实现二叉树的前中后序遍历
 * <p>
 * 注意三者的本质区别在于递归序
 *
 * @author TaoistQu
 */
public class RecursiveTraversalBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            value = data;
        }
    }

    public static void f(Node head) {
        if (head == null) {
            return;
        }
        f(head.left);
        f(head.right);
    }

    /**
     * 用递归方式实现先序遍历
     *
     * @param head
     */
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + "\t");
        pre(head.left);
        pre(head.right);
    }

    /**
     * 递归实现中序遍历
     *
     * @param head
     */
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.value + "\t");
        in(head.right);
    }

    /**
     * 用递归实现后序遍历
     *
     * @param head
     */
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.print(head.value + "\t");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.print("先序遍历：");
        pre(head);
        System.out.println();
        System.out.print("中序遍历：");
        in(head);
        System.out.println();
        System.out.print("后序遍历：");
        pos(head);
    }
}
