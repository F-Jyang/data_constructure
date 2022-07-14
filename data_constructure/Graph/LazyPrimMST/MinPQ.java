package Graph.LazyPrimMST;

import Graph.Edge;

public class MinPQ<T extends Comparable<T>> {
    T[] queue;
    int size;

    public MinPQ(int length) {
        size = 0;
        queue = (T[]) new Comparable[length];
    }

    public void swim(int index) {
        while (index / 2 >= 1 && less(index, index/2)) {
            exch(index / 2, index);
            index /= 2;
        }
    }

    public void sink(int index) {
        while (index * 2 < size) {
            int j = index * 2;
            if (less(j + 1, j)) j++;
            if (!less(j,index)) break;
            exch(j, index);
            index = j;
        }
    }

    private boolean less(int i, int j) {
        return queue[i].compareTo(queue[j]) < 0;
    }

    private void exch(int i, int j) {
        T temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    public T delMin() {
        T min = queue[1];
        exch(1, size);
        queue[size--] = null;
        sink(1);
        return min;
    }

    public void insert(T edge) {//索引0不存元素
        if (size + 1 > queue.length-1) reSize(2 * size + 1);
        queue[++size] = edge;
        swim(size);
    }

    private void reSize(int length) {
        Comparable[] old=queue;
        queue= (T[]) new Comparable[length];
        System.arraycopy(old, 0, queue, 0, old.length);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MinPQ<Integer> queue = new MinPQ<>(10);
        for (int i = 0; i < 10; i++) {
            queue.insert(i);
        }
        int j=queue.size;
        for (int i = 0; i < j; i++) {
            System.out.println(queue.delMin());
        }
    }
}
