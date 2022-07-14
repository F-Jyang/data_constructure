package Stack;


import java.util.ArrayList;
import java.util.List;

public class Stack<anyType> implements StackMethod<anyType>{
    private List<anyType> stack;
    private int count;
    public Stack() {
        stack= new ArrayList<anyType>();
        count=0;
    }
    @Override
    public anyType push(anyType val) {
        stack.add(count,val);
        count++;
        return stack.get(count-1);
    }
    @Override
    public anyType pop() {
        if(count==0){
            throw new IndexOutOfBoundsException();
        }
        count--;
        return stack.get(count-1);
    }

    @Override
    public anyType top() {
        if(count==0){
            throw new IndexOutOfBoundsException();
        }
        return stack.get(count-1);
    }
    public anyType search(int index){
       return stack.get(index);
    }
}
