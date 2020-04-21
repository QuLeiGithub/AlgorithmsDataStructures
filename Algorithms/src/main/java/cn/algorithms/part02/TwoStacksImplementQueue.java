package cn.algorithms.part02;

import java.util.Stack;

/**
 * 两个栈实现队列
 * <p>
 * 实现时需要满足两点：
 * 1.如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush中的数据全部压入
 * 2.如果stackPop不为空，stackPush绝对不能向stackPop中压入数据。违反了以上两点都会发生错误
 *
 * @author TaoistQu
 */
public class TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        /**
         * push栈向pop栈倒入数据
         */
        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public int poll() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

        public void push(int value) {
            stackPush.push(value);
            pushToPop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
