package Solution;

import java.util.Arrays;
import java.util.LinkedList;

public class KthLargest {
    int k;
    LinkedList<Integer> list;

    //将数组存入arraylist list
//每次存入都对list遍历
//然后存入，遍历k次，得到第k大的值
    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        list = new LinkedList<>();
        for (int i :
                nums) {
            list.add(i);
        }
    }

    public int add(int val) {
        if(list.size()==0){
            list.add(val);
            return val;
        }
        int length = list.size();
        for (int i = 1; i < length; i++) {
            if (list.get(i - 1) <= val && list.get(i) >= val) {
                list.add(i, val);
                break;
            }
            if (list.get(list.size() - 1) <= val) {
                list.add(val);
                break;
            }
        }
        int answer = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i - 1) < list.get(i)) {
                answer++;
            }
            if (answer == k) {
                break;
            }
        }
        return list.get(list.size() - answer);
    }

    public static void main(String[] args) {
        int[] numbers = {4, 5, 8, 2};
        KthLargest k1 = new KthLargest(3, numbers);
        System.out.println(k1.add(3));
        System.out.println(k1.add(5));
        System.out.println(k1.add(10));
        System.out.println(k1.add(9));
        System.out.println(k1.add(4));
    }
}
