package Sort;

//对两个有序的子数组排序的方法
public class merge {
    //用来处理排序好的两个数组的方法
    private static void merge(Comparable[] a, int start, int mid, int end) {
        Comparable[] ans = new Comparable[a.length];
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            ans[k] = a[k];
        }
        for (int k = start; k <= end; k++) {
            //前两个对应的是两个数组中的一个已经被全部添加进ans数组后的情况
            if (i > mid) {
                a[k] = ans[j++];
            } else if (j > end) {
                a[k] = ans[i++];
                //后两个对应的是两个数组都没有或者没有完全添加进ans数组时的情况
            } else if (Example.less(ans[j], ans[i])) {
                a[k] = ans[j++];
            } else {
                a[k] = ans[i++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int start, int end) {
        //将数组0，a.length排序
        if (end <= start) return;//递归结束条件
        int mid = start + (end - start) / 2;
        sort(a, start, mid);//将start到mid排序
        sort(a, mid + 1, end);//将mid+1到end排序
        merge(a, start, mid, end);//对前面的两个排序进行处理
    }

    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        merge.sort(a);
        Example.show(a);
    }
}