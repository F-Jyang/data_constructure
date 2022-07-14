package Sort;

public class HeapSort<val extends Comparable<val>> {
    private HeapSort() {
    }

    public static void sort(Comparable[] arr) {
        int N = arr.length-1;
        for (int i = N/ 2; i >= 0; i--) {
            sink(arr, i, N);
        }
        while (N >= 0) {
            exch(arr, 0, N--);
            sink(arr, 0, N);
        }
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sink(Comparable[] arr, int i, int j) {
        while (2 * i <= j) {
            int k = 2 * i;
            if (k < j && less(arr, k, k + 1)) {
                k++;
            }
            if (!less(arr, i, k)) {
                break;
            }
            exch(arr, i, k);
            i = k;
        }
    }

    private static boolean less(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[100000000];
        Integer[] arr2=new Integer[arr.length];
//        Integer[] arr3=new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
            arr2[i]=i;
//            arr3[i]=i;
        }
        long start=System.currentTimeMillis();
        HeapSort.sort(arr);
        long end=System.currentTimeMillis();
        System.out.println((end-start)+"ms");
        long start2=System.currentTimeMillis();
        Quick2.sort(arr2);
        long end2=System.currentTimeMillis();
        System.out.println((end2-start2)+"ms");
//        Quick.sort(arr3);
    }
}
