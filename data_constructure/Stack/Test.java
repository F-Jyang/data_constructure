package Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<Integer>();
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.push(3));
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.search(0));
    }
}
