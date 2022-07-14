package PriorityQueue;

class MinPQ {
    int[] arr;
    int size;

    public MinPQ(int length) {
        arr = new int[length + 1];
        size=0;
    }

    public void enqueue(int num) {
        arr[++size] = num;
        swim(size);
    }

    public void swim(int index) {
        while (index / 2 >= 1) {
            int i = index / 2;
            if (arr[i] > arr[index]) exch(index, i);
            index = i;
        }
    }

    public int deMin(int index) {
        int min = arr[1];
        arr[1] = arr[size--];
        sink(1);
        return min;
    }

    private void sink(int index) {
        while (index * 2 <= size) {
            int i = index * 2;
            if (i < size && arr[i] > arr[i + 1]) i++;
            if (arr[index] <= arr[i]) break;
            exch(index, i);
            index =i;
        }
    }
    public void show(){
        int j=size;
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i]+",");
        }
    }

    private void exch(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}