package Sort;

public class Quick2 {
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    //三向分段
    public static void sortThreeWays(Comparable[] arr) {
        sortThreeWays(arr, 0, arr.length - 1);
    }
    //随机值快排
    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi)return;
        // 当一定的排序后换为插入排序，发现栈溢出了，而且速度更慢
            /*{
            for (int i = 1; i < arr.length; i++) {
                for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }*/
        //lef和right一定要有！！！不能用0和arr.length代替，否则会栈溢出
        int left = lo;
        int right = hi;

        int index=(int)(lo+Math.random()*(hi-lo));
        Comparable temp = arr[index];
        arr[index]=arr[lo];
        arr[lo]=temp;
        while (left < right) {
            while (left < right && arr[right].compareTo(temp) >= 0) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left].compareTo(temp) <= 0) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        sort(arr, lo, left - 1);
        sort(arr, right + 1, hi);
    }


    /*
    当random的值为0~100时，栈会溢出，当为0~1000时，三向切分的速度大概是其他两个的4倍左右
    取极限时，即random值为0~1，数组长度10000，三向切分1ms，而其他两种方式均为200ms左右，并且普通快排最慢
    随着random的不断扩大，也就是重复的数字不断减少，三向切分的速度越来越慢
    当random的值为0~10000000，数组大小为10000000时，三向切分的速度已经变成二向切分的一半

    */
    private static void sortThreeWays(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi, i = lo + 1;
        Comparable v = arr[lo];
        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0) {
                Comparable temp = arr[i];
                arr[i++] = arr[lt];
                arr[lt++] = temp;
            } else if (cmp > 0) {
                Comparable temp = arr[i];
                arr[i] = arr[gt];
                arr[gt--] = temp;
            } else {
                i++;
            }
        }
        sortThreeWays(arr, lo, lt - 1);
        sortThreeWays(arr, gt + 1, hi);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[2000000];
        Integer[] arr2 = new Integer[2000000];
        Integer[] arr3 = new Integer[2000000];
        for (int i = 0; i < arr.length; i++) {
         /*   arr[i] =i;//取最左值快速排序
            arr2[i] = i;//随机快速排序
            arr3[i] = i;//三向分段快速排序*/
            int random=(int)(Math.random()*30000);
            arr[i] =random;//取最左值快速排序
            arr2[i] = random;//随机快速排序
            arr3[i] = random;//三向分段快速排序
        }
        long start = System.currentTimeMillis();
        Quick.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");

        long start1 = System.currentTimeMillis();
        Quick2.sort(arr3);
        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1) + "ms");


        long start2 = System.currentTimeMillis();
        Quick2.sortThreeWays(arr2);
        long end2 = System.currentTimeMillis();
        System.out.println((end2 - start2) + "ms");

        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Quick.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Quick2.sort(b);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        String[] c = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Quick2.sortThreeWays(c);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
