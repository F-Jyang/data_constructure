package Sort;

public class Test {
    public static void main(String[] args) {
        String[] arr1 = new String[300000];
        String[] arr2 = new String[300000];
        String[] arr3 = new String[300000];
        String[] arr4 = new String[300000];
        String[] arr5 = new String[300000];
        for (int i = 0; i < 300000; i++) {
            int j = (int) (Math.random() * 1000000);
            arr1[i] = Integer.toString(j);
            arr2[i] = Integer.toString(j);
            arr3[i] = Integer.toString(i);
            arr4[i] = Integer.toString(i);
            arr5[i] = Integer.toString(i);
        }

        double time2 = Example.time("Shell", arr1);
        System.out.println(time2+"s");

        double time3 = Example.time("Insertion", arr3);
        System.out.println(time3+"s");

//        double time1 = Example.time("Selection", arr2);
//        System.out.println(time1);

        double time4 = Example.time("merge", arr4);
        System.out.println(time4+"s");

        double time5 = Example.time("Quick", arr5);
        System.out.println(time5+"s");
    }
}
