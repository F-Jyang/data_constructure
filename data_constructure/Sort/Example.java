package Sort;

public class Example<T> {
    //对数组排序，具体排序的方式不一样
    public static void sort(Comparable[] a) {
    }

    //交换两个元素的顺序
    public static void exch(Comparable[] a, int i, int j) {
        Comparable k = a[i];
        a[i] = a[j];
        a[j] = k;
    }

    //判断w元素是否小于v
    public static boolean less(Comparable w, Comparable v) {
        return w.compareTo(v) < 0;
    }

    //测试程序是否有序(升序)
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i], a[i + 1])) return false;
        }
        return true;
    }

    //用来输出数组的元素
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i] + ",");
            }
        }
    }

    public static double time(String arg, Comparable[] a) {
        double starTime = System.currentTimeMillis();
        if (arg.equals("Insertion")) Insertion.sort(a);
        if (arg.equals("Selection")) Selection.sort(a);
        if (arg.equals("Shell")) Shell.sort(a);
        if (arg.equals("merge")) merge.sort(a);
        if (arg.equals("Quick")) merge.sort(a);
        double endTime = System.currentTimeMillis();
        return (endTime - starTime) / 1000;
    }
}
