package PriorityQueue;

import java.nio.BufferUnderflowException;

/*
优先队列：
允许至少两种操作：插入和删除最小值
二叉堆：完全二叉树，节点值小于其子节点的值，最小的值可以在子节点找到
将二叉堆的节点的值放入一个数组中，我们可以得到一些规律：
    假设当前节点为X，在数组的索引i，则X的父节点的索引为i/2，左孩子索引2i，右孩子索引2i+1；
 */
public class BinaryHeap<anyType extends Comparable<? super anyType>> {
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (anyType[]) new Comparable[capacity+1];
    }

    public BinaryHeap(anyType[] items) {
        currentSize = items.length;
        array = (anyType[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (anyType item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);//下滤
        }
    }

    //插入操作
    public void insert(anyType x) {
        if (currentSize == array.length - 1) {
            enLargeArray((currentSize * 2) + 1);
        }
        //上滤:向数组的尾部添加一个元素，然后让元素上滤
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            //不断将元素向后移动
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    public anyType deleteMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        anyType minItem = findMin();
        array[1] = array[currentSize --];//删除最小值：用数组的最后一个元素替换这个值
        percolateDown(1);//然后将这个值下沉
        return minItem;
    }

    //下滤:将数组索引为hole的值与左右子节点比较并向下沉
    private void percolateDown(int hole) {//从hole开始下沉
        int child;
        anyType tmp = array[hole];//下沉的值

        for (; hole * 2 <= currentSize; hole = child) {//hole*2，hole值的子节点
            // <currentSize说明hole有子节点
            child = hole * 2;//hole的左子节点

            //找出最小子节点
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;//如果该字节点不是最后一个字节点，且最后一个子节点大于该子节点，则将子节点向右移动
            }

            //比较最小子节点和hole（父节点）的值，比hole节点小则替代hole节点，比它大则退出循环
            if (array[child].compareTo(tmp) < 0) {//比较子节点与父节点的值，子节点的值小于父节点则将子节点的值填充到父节点
                array[hole] = array[child];
            } else {
                break;//如果最小子节点的值大于父节点，则break
            }
        }
        //最后让hole的值为最后原数组最后一个索引对应的值
        array[hole] = tmp;
    }

    public anyType findMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return array[1];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    private void enLargeArray(int newSize) {
        anyType[] old = array;
        array = (anyType[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    private static final int DEFAULT_CAPACITY = 10;//堆默认长度
    private int currentSize;//当前堆长度
    private anyType[] array;//堆数组

    // Test program
    public static void main(String[] args) {
    /*    int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>();
        int i = 37;

        for (i = 37; i != 0; i = (i + 37) % numItems)
            h.insert(i);
        for (i = 1; i < numItems; i++)
            if (h.deleteMin() != i)
                System.out.println("Oops! " + i);*/

        BinaryHeap<Integer> h = new BinaryHeap<>();
        for (int i = 0; i < 1000; i++) {
            h.insert(i);
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println(h.findMin());
            h.deleteMin();
        }
    }
}
