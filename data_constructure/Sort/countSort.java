package Sort;

/*
计数排序：传入数组arr1，将arr1的中元素的值作为arr2的索引，
        arr2中将所有的元素初始化为0，将arr1的值作为索引，arr1遇到某个值时就将该值在arr2对应的索引+1
        比如arr1[1]=2，则arr2[2]的值+1。
        即arr2中索引为arr1的值，arr2的元素为arr1中该值对应的个数，如arr2[50]=2，则代表arr1中有两个值为50的元素
    特点：内存爆炸，但是速度很快的排序，负数没办法使用

 */
public class countSort<val extends Comparable<val>> {
    private countSort() {
    }

    public static void countSort(int[] arr) {
        int max = arr[0];
        //得到arr中最大的数
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //这里的数组的索引最大值要加一，因为索引从0开始，否则最后得到的输出结果会小1或者出现索引越界的异常
        //比如max=75，则索引的最大值为74，那么最后给数组赋值的时候，最大的值就是74，而不是75
        int[] arr2 = new int[max + 1];
        //将arr2的数组初始化为0
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 0;
        }
        //将arr中的数转移到arr2
        for (int i = 0; i < arr.length; i++) {
            arr2[arr[i]] = arr2[arr[i]] + 1;
        }
        //将arr2的数据排序后转移到arr
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = arr2[i]; j > 0; j--) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 23, 5, 5, 6, 12, 8, 37, 128, 12, 3, 43, 5, 6, 7};
        countSort.countSort(arr);
        for (int i : arr
        ) {
            System.out.println(i + ",");
        }
    }
}
