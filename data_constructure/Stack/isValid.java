package Stack;
/*
有效括号
//定义一个栈用来存储左括号
//定义一个字典，用来存放键值对右括号->左括号
//循环遍历s中的括号，左括号存入栈中
//当遇到第一个右括号时，我们可以判断它的左边一定是一个左括号
//这时就把栈顶左括号与map中的右括号对应值比较（并且比较后要把这个元素推出栈，可以保证下一个左括号仍然对应右括号）
 */
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class isValid {
    public boolean isValid(String s) {
    /*    Stack<Character> stack=new Stack<Character>();
        char[] chars=s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            stack.push(chars[i]);
        }
        HashMap<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        boolean isFlag=true;
        for (int i = chars.length/2; i < chars.length; i++) {
            if(chars[i]!=map.get(stack.pop())){
                isFlag=false;
            }
        }
        return isFlag;*/
        int n = s.length();
        if (n % 2 == 1) return false;
        //这里定义一个字典，用来存放键值对右括号->左括号
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            //循环遍历s中的括号，左括号存入栈中
            //当遇到第一个右括号时，我们可以判断它的左边一定是一个左括号
            //这时就把栈顶左括号与map中的右括号对应值比较（并且比较后要把这个元素推出栈）
            if(map.containsKey(ch)){
                //这里判断栈为空可以减少计算的次数，提高效率
                if(stack.peek()!=map.get(ch)||stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        //注意为栈可能为空！！！
        return stack.isEmpty();
    }
}
