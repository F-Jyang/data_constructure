package Sort;

//插入排序（有点像冒泡算法？？？）
/*
思路:
    传入一个数组，从后往前比较，如果前面的数大于后面的数，两者交换位置
步骤：
    1、第一个for循环控制从后往前开始的索引
    2、第二个for循环从第一个for循环得到的值开始，和前面的值的大小
        大于则退出循环
        小于则继续循环交换两个数组元素的位置
应用：
    1、数组中的每个元素距离它的目标位置都不远时
    2、数组中只有几个元素的位置不正确
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {//i是插入的索引，j是与i比较和交换的索引
            for (int j = i; j >= 0 && Example.less(a[j + 1], a[j]); j--) {
                Example.exch(a, j + 1, j);
            }
        }
    }

    public static void main(String[] args) {
        Insertion is = new Insertion();
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Insertion.sort(a);
        Example.show(a);
        double time = Example.time("Selection", a);
    }
}
