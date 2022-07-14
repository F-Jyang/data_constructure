package PriorityQueue;

import java.util.Calendar;
import java.util.List;
import java.util.Queue;

public class MyBinaryHeap {
    private int size=0;
    private  static  final int DEFAULT_SIZE=10;
    private int currentSize=0;
    private int[] heap;
    public MyBinaryHeap(){
        this.size=DEFAULT_SIZE;
        this.heap=new int[DEFAULT_SIZE+1];
    }
    public MyBinaryHeap(int capacity){
        this.size=capacity;
        this.heap=new int[capacity+1];
    }
    public MyBinaryHeap(int[] arr){
        this.currentSize=arr.length;
        this.size=arr.length+1;
        heap=new int[size];
        for(int i=1;i<=arr.length;i++){
            heap[i]=arr[i-1];
        }
        buildHeap();
    }

    public void buildHeap(){
        for(int i=currentSize/2;i>0;i--){
            sink(i);
        }
    }
    public void sink(int idx_father){
        int idx_child=idx_father*2;
        if(idx_child>currentSize)return;
        int temp=heap[idx_father];
        while (idx_child<=currentSize){
            if(idx_child+1<=currentSize&&heap[idx_child]>heap[idx_child+1]){
                idx_child++;
            }
            if(heap[idx_father]>heap[idx_child]){
                heap[idx_father]=heap[idx_child];
                idx_father=idx_child;
                idx_child*=2;
                heap[idx_father]=temp;
            }else {
                break;
            }
        }
    }
    public int delMin(){
        if(currentSize<1)return -1;
        int res=heap[1];
        heap[1]=heap[currentSize--];
        sink(1);
        return res;
    }

    public void insert(int val){
       if(++currentSize>=size)reSize(2*currentSize+1);
       heap[currentSize]=val;
       swim(currentSize);
    }

    public void swim(int idx_child){
        if(idx_child/2<1)return;
        int idx_father=idx_child/2;
        while (idx_child>0&&heap[idx_child]<heap[idx_father]){
            int temp=heap[idx_child];
            heap[idx_child]=heap[idx_father];
            heap[idx_father]=temp;
            idx_child=idx_father;
            idx_father/=2;
        }
    }
    public boolean isEmpty(){
        return currentSize==0;
    }
    public void show(){
        int num_idx=1;
        int num_cur=1;
//        System.out.println(currentSize);
        while (num_cur<currentSize){
            for(int i=num_idx;i<num_cur+num_idx&&i<=currentSize;i++){
//                System.out.println(1);
                System.out.print(heap[i]+" ");
            }
            System.out.println();
            num_idx+=num_cur;
            num_cur*=2;
        }
    }

    public void reSize(int capacity){

    }

    public static void main(String[] args) {
        int arr[]={234,2341,3,4,21,43,5,23,34};
        MyBinaryHeap myBinaryHeap=new MyBinaryHeap(arr);
        myBinaryHeap.show();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(myBinaryHeap.delMin()+" ");
        }
    }
}
