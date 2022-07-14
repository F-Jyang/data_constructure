package edu.gdut2.Test3;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    List<T> stack;
    public MyStack(){
        stack=new ArrayList<>();
    }
    public boolean isEmpty(){
        return stack.size()==0;
    }

    public int getSize(){
        return stack.size();
    }

    public T peek(){
        return stack.get(stack.size()-1);
    }
    public T pop(){
        return stack.remove(stack.size()-1);
    }
    public void push(T t){
        stack.add(t);
    }

    public int search(T t){
        int ans=-1;
        for (int i = 0; i < stack.size(); i++) {
            if(t==stack.get(i)){
                ans=i;
            }
        }
        return ans;
    }
}
