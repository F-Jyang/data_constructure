package PriorityQueue;

public class MaxBinaryHeap<key extends Comparable<key>> {
    private key[] heap;//插入的数据在1~size-1中，0不被使用
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    public MaxBinaryHeap() {
        this(DEFAULT_SIZE);
    }

    private MaxBinaryHeap(int size) {
        heap = (key[]) new Comparable[size];
    }

    //删除最大值
    public key delMax() {
        if (size + 1 <= heap.length / 2) reduceSize(heap.length / 2);
        key max = (key) heap[1];
        exch(1, size--);
        heap[size + 1] = null;
        sink(1);
        return max;
    }

    private void sink(int i) {
        while (2 * i < size) {
            int j = 2 * i;
            if (j < size && less(j, j + 1)) j++;
            if (!less(i, j)) break;
            exch(i, j);
            i = j;
        }
    }

    //减少长度
    private void reduceSize(int size) {
        key[] old = heap;
        heap = (key[]) new Comparable[size];
        System.arraycopy(old, 0, heap, 0, size);
    }

    //插入数据
    public void insert(key key) {
        if (size + 1 > heap.length - 1) enLargeSize(2 * size + 1);
        heap[++size] = key;
        swim(size);
    }

    private void swim(int i) {
        while (i / 2 >= 1 && less(i / 2, i)) {
            exch(i / 2, i);
            i /= 2;
        }
    }

    //获得数据
    public key get(int i) {
        return heap[i];
    }

    //获得数组长度
    public int getSize() {
        return size;
    }

    //增加数组长度
    private void enLargeSize(int size) {
        Comparable[] old = heap;
        heap = (key[]) new Comparable[size];
        System.arraycopy(old, 0, heap, 0, old.length);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void show() {
        System.out.print("[");
        for (int i = 1; i <= size; i++) {
            if (i == size) {
                System.out.print(get(i));
                break;
            }
            System.out.print(get(i) + ",");
        }
        System.out.println("]");
    }


    //比较大小
    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    //交换元素
    private void exch(int i, int j) {
        key temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<>();
        for (int i = 0; i < 21; i++) {
            heap.insert(i);
        }
        for (int i = 0; i < 15; i++) {
            heap.show();
            heap.delMax();
        }
        heap.show();

        /*for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }*/
    }
}
