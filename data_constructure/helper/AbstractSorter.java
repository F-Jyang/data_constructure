package helper;



/**
 * User: Shawn cao
 * Date: 14-5-8
 * Time: PM5:53
 */
public abstract class AbstractSorter {
    public int exchangeCount = 0;
    public static int compareCount = 0 ;

    public abstract void sort(Comparable[] arr);


    public static  boolean less(Comparable a, Comparable b){
           compareCount++;
        return a.compareTo(b) < 0;
    }

    public void exchange(Comparable[] arr, int i, int j){
        Comparable t = arr[i];
        arr[i] = arr[j] ;
        arr[j] = t;
        exchangeCount++;
    }

    public  void show(Comparable[] arr){
        for(int i = 0; i< arr.length; i++) StdOut.print(arr[i] + " ");
        StdOut.println();
    }

    public static <T> boolean isSorted(Comparable<T>[] arr){
        for(int i = 1; i < arr.length; i++){
            if(less(arr[i], arr[i - 1])) return false;
        }
        return true;
    }


    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


}
