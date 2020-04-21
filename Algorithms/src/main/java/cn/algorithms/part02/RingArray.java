package cn.algorithms.part02;

/**
 * @author TaoistQu
 */
public class RingArray {
    /**
     * 实现一个固定大小的栈
     */
    public static class MyStack {
        private int[] arr;
        private int topIndex;
        private final int limit;

        public MyStack(int l) {
            arr = new int[l];
            limit = l;
        }

        public void push(int value) {
            if (topIndex == limit) {
                throw new RuntimeException("栈满了，不能再继续添加元素！！！");
            }
            arr[topIndex++] = value;
        }

        public int pop() {
            if (topIndex == 0) {
                throw new RuntimeException("栈空了，不能再取元素啦！！！");
            }
            return arr[--topIndex];
        }

        public boolean isEmpty() {
            return topIndex == 0;
        }

    }

    /**
     * 实现一个循环队列；用size解耦pushi 和 polli队列的两个索引
     */
    public static class MyQueue {
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int l) {
            arr = new int[l];
            limit = l;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再继续添加元素！！！");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再取元素啦！！！");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 循环索引
         *
         * @param i
         * @return
         */
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }


    public static void main(String[] args) {
        MyQueue myStack = new MyQueue(10);
        //MyStack myStack = new MyStack(10);
        for (int i = 1; i <= 10; i++) {
            myStack.push(i);
        }
        for (int i = 1; i <= 5; i++) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println();
        for (int i = 11; i <= 14; i++) {
            myStack.push(i);
        }
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println();
    }
}


