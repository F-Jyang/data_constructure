package QueueAndStack;

import java.util.Stack;

/*
用栈实现队列
性质：先入后出->先进先出

 */
public class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> queue;

    public MyQueue() {
        stack = new Stack<Integer>();
        queue = new Stack<Integer>();
    }

    public void push(int x) {
        while (!queue.isEmpty()) {
            stack.push(queue.pop());
        }
        queue.push(x);
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
    }

    public int pop() {
        if(empty())return -1;
        return queue.pop();

    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty()&& stack.isEmpty();
    }
}
