package Stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer> mystack;

    public MinStack() {
        mystack = new ArrayList<Integer>();
    }

    public void push(int val) {
        mystack.add(mystack.size(), val);
    }

    public void pop() {
        if (mystack.isEmpty()) return;
        mystack.remove(mystack.size() - 1);
    }

    public int top() {
        if (mystack.isEmpty()) return -1;
        return mystack.get(mystack.size() - 1);
    }

    public int getMin() {
        List<Integer> minstack2=new ArrayList<Integer>();
        int min = top();
        int temp=min;
        pop();
        while (mystack.isEmpty() == false) {
            if (top() < min) {
                temp=min;
                min = top();
                minstack2.add(temp);
            } else {
                minstack2.add(top());
            }
            pop();
        }
        mystack=minstack2;
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
