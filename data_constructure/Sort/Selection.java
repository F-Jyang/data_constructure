package Sort;

//选择排序
/*
每次循环都找出最小的数字与前面的数字互换下标
比如：
第一次找到最小的数字，与0下标互换位置
第二次找到第二小的数字，与1下标互换数字
步骤：
    1、第一个for循环：用来得到要被更换的数组的下标
    2、第二个for循环：用来得到最小元素
    3、循环后交换两个元素得位置
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;//min存储的是最小元素的下标
            for (int j = i + 1; j < N; j++) {
                if (Example.less(a[j], a[min])) min = j;
            }
            Example.exch(a, min, i);
        }
    }

    public static void main(String[] args) {
        Selection se = new Selection();
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Selection.sort(a);
        Example.show(a);
    }
}
//output:A,E,E,L,M,O,P,R,S,T,X