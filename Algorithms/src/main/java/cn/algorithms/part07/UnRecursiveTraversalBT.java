package cn.algorithms.part07;

import java.util.Stack;

/**
 * 非递归实现二叉树打印
 *
 * @author TaoistQu
 */
public class UnRecursiveTraversalBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            value = data;
        }
    }

    /**
     * 用栈实现二叉树的前序遍历
     * 1）弹出打印
     * 2）如果有右孩子，压入右孩子
     * 3）有左孩子压入左孩子
     *
     * @param head
     */
    public static void pre(Node head) {
        System.out.print("pre-order:\t");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + "\t");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void in(Node head) {
        System.out.print("in-order:\t");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + "\t");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 用两个栈实现后序打印
     *
     * @param head
     */
    public static void pos1(Node head) {
        System.out.print("pos-order:\t");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.add(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + "\t");
            }
        }
        System.out.println();
    }

    /**
     * 用一个栈实现二叉树后序遍历
     * 具体过程多理解实例
     *
     * @param h
     */
    public static void pos2(Node h) {
        System.out.print("pos-order:\t");
        if (h != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + "\t");
                    h = c;
                }
            }
        }
        System.out.println();
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
        System.out.print("中序遍历：");
        in(head);
        System.out.print("后序遍历1：");
        pos1(head);
        System.out.print("后序遍历2：");
        pos2(head);
    }
}
