package Stack;
/*/**
 * #Description stack 练习
 * @param
 * @return
 * @author jiongyang
 * #Date 2022/4/2
 */


//基于链表
public class MyStack<E extends Comparable<E>> implements MyStackImpl<E> {
    private static int SIZE = 11;
    private Comparable[] stack;
    private int size;
    private int length;

    public MyStack() {
        length=-1;
        this.size = SIZE;
        stack = new Comparable[size];
    }

    @Override
    public E push(E val) {
        if (length>=size-1)reSize();
        stack[++length]=val;
        return val;
    }

    @Override
    public E pop() {
        if(length<0)return null;
        E res=(E) stack[length];
        stack[length]=null;
        length--;
        return res;
    }

    @Override
    public E peek() {
        if(length<0)return null;
        return (E) stack[length];
    }

    @Override
    public boolean empty() {
        return length==0;
    }

    @Override
    public int search(E val) {
        for (int i = 0; i < length; i++) {
            if(stack[i].compareTo(val)!=0)continue;
            return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return length+1;
    }

    private void reSize(){
        size=2*(size+1);
        Comparable[] arr=new Comparable[size];
//        if (size >= 0) System.arraycopy(stack, 0, arr, 0, size);
        for(int i=0;i<=length;i++){
            arr[i]=stack[i];
        }
        stack=arr;
    }
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(21);
        stack.push(23);
        stack.push(22);
        stack.push(233);
        stack.push(3432);
        stack.push(314);
        stack.push(323);
        stack.push(334);
        stack.push(312);
        stack.push(334);
        stack.push(355);
        stack.push(3);
        int size=stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    /*private LinkedList<E> stack;
    private int size;

    public MyStack() {
        this.stack = new LinkedList<>();
        this.size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public E push(E val) {
        stack.add(val);
        size++;
        return val;
    }

    @Override
    public E pop() {
        if (stack.size() == 0) return null;
        E temp = stack.get(0);
        stack.remove(size - 1);
        size--;
        return temp;
    }

    @Override
    public E peek() {
        if (stack.size() == 0) return null;
        return stack.get(size-1);
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int search(E val) {
        int idx = -1;
        for (int i = 0; i < size; i++) {
            if (stack.get(i).compareTo(val) != 0) break;
            idx = i;
        }
        return idx;
    }*/
}
