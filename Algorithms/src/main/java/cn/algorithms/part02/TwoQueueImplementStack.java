package cn.algorithms.part02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 *
 * @author TaoistQu
 */
public class TwoQueueImplementStack {
    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T poll() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public T peek(){
            while (queue.size() >1){
                help.offer(queue.poll());
            }
            T ans = queue.peek();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
           //help.offer(ans);
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        TwoQueueStack<Integer> stack = new TwoQueueStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        while (!stack.isEmpty()){
            System.out.print(stack.poll()+" ");
        }
    }
}
