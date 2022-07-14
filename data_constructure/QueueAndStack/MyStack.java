package QueueAndStack;
/*
队列->栈
先进后出->先进先出
 */

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;
    Queue<Integer> stack;

    public MyStack() {
        queue = new LinkedList<Integer>();
        stack = new LinkedList<Integer>();
    }

    public void push(int x) {
        while (!queue.isEmpty()) {
            stack.add(queue.remove());
        }
        queue.add(x);
        while (!stack.isEmpty()) {
            queue.add(stack.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty() && stack.isEmpty();
    }
}

