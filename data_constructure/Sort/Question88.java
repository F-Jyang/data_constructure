package Sort;

public class Question88 {
    public static void main(String[] args) {
        int[] a = {1, 4, 23, 0, 0, 0, 0};
        int[] b = {2, 5, 23, 324};
        merge(a, 3, b, 4);
        for (int i :
                a) {
            System.out.print(i + ",");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] answer = new int[m + n];
        int i = 0;//第一个元素指针
        int j = 0;//第二个元素指针
        int k = 0;//答案的指针
        while (i < m || j < n) {
            if (j >= n) {
                answer[k++] = nums1[i++];
            } else if (i >= m) {
                answer[k++] = nums2[j++];
            } else if (nums1[i] <= nums2[j]) {
                answer[k++] = nums1[i++];
            } else if (nums2[j] <= nums1[i]) {
                answer[k++] = nums2[j++];
            }
        }
        int a = 0;
        for (int num : answer
        ) {
            nums1[a++] = num;
        }
    }
       /* int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }*/
}
