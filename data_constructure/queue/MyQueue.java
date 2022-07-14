package queue;

public class MyQueue {
    private int[] queue;
    public MyQueue(){
        queue=new int[0];
    }
//    队列增加元素方法
    public int add(int element){
//        创建一个新数组，最后要把新数组赋值给旧数组
        int[] newqueue=new int[queue.length+1];
        for (int i = 0; i < queue.length; i++) {
            newqueue[i]=queue[i];
        }
        newqueue[queue.length]=element;
        queue=newqueue;
        return element;
    }
//    队列消去元素方法
    public int poll(){
       int[] newqueue=new int[queue.length-1];
        for (int i = 0; i < newqueue.length; i++) {
            newqueue[i]=queue[i+1];
        }
        int element=queue[0] ;
        queue=newqueue;
        return element;
    }
//    判断队列是否为空
    public boolean isEmpty(){
        return queue.length==0;
    }
}
