package Sort;


/*
快速排序：当两个子数组有序时，整个数组有序
            简单来说就是拆东墙补西墙
 */
public class Quick {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        //至少要有两个元素时才调用排序
        if (lo >= hi) return;//递归的结束语句
        int left = lo;
        int right = hi;
        Comparable temp = a[lo];//待排序的元素的第一个元素作为基准元素
        while (left < right) {
            while (right > left && a[right].compareTo(temp) >= 0) {
                //因为temp拆了最左边的节点，所以要拆右边的节点去补它
                right--;//扫描右边元素，找到第一个小于基准元素的元素，拆掉补回右边
            }
            a[left] = a[right];
            while (left < right && a[left].compareTo(temp) <= 0) {
                left++;//扫描左边的元素，找到第一个大于基准元素的元素，补回刚刚被拆的左边元素
            }
            a[right] = a[left];
        }
        a[left] = temp;//最后的基准元素归位
        sort(a, lo, left - 1);//搞定基础元素左边元素
        sort(a, right + 1, hi);//搞定基础元素右边元素
    }


    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Quick.sort(a);
        Example.show(a);
    }
}
