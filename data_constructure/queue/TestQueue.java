package queue;
//测试queue类
public class TestQueue {
    public static void main(String[] args) {
        MyQueue queue=new MyQueue();

        queue.add(11);
        queue.add(99);
        queue.poll();
        queue.poll();
        System.out.println(queue.isEmpty());
    }
}
