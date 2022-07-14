package helper;



/**
 * User: Shawn cao
 * Date: 14-5-9
 * Time: PM1:34
 */
public class SortCompare<T> {

    public static double time(AbstractSorter sorter , Comparable[] arr){
        Stopwatch timer = new Stopwatch();
        sorter.sort(arr);
        return timer.elapsedTime() ;
    }

    public static double timeRandomInput(AbstractSorter sorter, int N , int T){

        double total = 0.0;
        Double[] arr = new Double[N];
        for(int t = 0; t < T; t++){
            for(int i = 0; i < N ; i ++){

                arr[i] = StdRandom.uniform();
            }
            total += time(sorter, arr);
        }
        return total;
    }
}
