package Sort;

public class sortArray {


    public int[] sortArray(int[] nums) {
        sortThreeWays(nums, 0, nums.length - 1);
        return nums;
    }

    public int[] randomSortArray(int[] nums) {
        quickSort_random(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortThreeWays(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        int temp = arr[lo];
        while (i <= gt) {
            if (arr[i] > temp) {
                int ch = arr[i];
                arr[i] = arr[gt];
                arr[gt--] = ch;
            } else if (arr[i] < temp) {
                int ch = arr[i];
                arr[i++] = arr[lt];
                arr[lt++] = ch;
            } else {
                i++;
            }
        }
        sortThreeWays(arr, lo, lt - 1);
        sortThreeWays(arr, gt + 1, hi);
    }

    private void quickSort_random(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int left = lo, right = hi, index = lo + (int) (Math.random() * (hi - lo));
        int temp = arr[index];
        arr[index] = arr[lo];
        arr[lo] = temp;
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];

        }
        arr[left] = temp;
        quickSort_random(arr, lo, left - 1);
        quickSort_random(arr, right + 1, hi);
    }

    public static void main(String[] args) {
        /*int[] arr = {13, 2, 43, 23, 4, 23, 5, 3241, 243,35435,432543,23453534,32423,3};
        new sortArray().randomSortArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
    }
}
