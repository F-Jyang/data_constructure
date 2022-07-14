package Sort;

/*
希尔排序：将插入排序（两个交换的元素间隔1）的间隔从n递减到1，且边减边将子数组排序
        记住插入排序的实质：将数组从后往前排序
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 2)//这里的2与下面的两个2要相同，不然可能得不到h=1时得排序
            h = 3 * h ;
        while (h >= 1) {
            for (int i = h; i < N; i++) {//用来的得到子数组
                for (int j = i; j >= h && Example.less(a[j], a[j - h]); j--) {//用来对子数组进行排序
                    Example.exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        String[] a = {"L","df","as","s","we","S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Shell.sort(a);
        Example.show(a);
    }
}
//output:A,E,E,L,M,O,P,R,S,T,X