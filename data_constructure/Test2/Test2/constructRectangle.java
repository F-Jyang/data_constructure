package Test2.Test2;

import java.util.ArrayList;

public class constructRectangle {
    public static int[] constructRectangle(int area) {
        int[] ans=new int[2];
        int temp=0;
        for (int i = area; i >=0; i--) {//宽
            for (int j = 1; j <= area; j++) {//长
                if (i * j == area && i >= j) {
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       int[] arr= constructRectangle(4);
        for (int i:arr
             ) {
            System.out.println(i);

        }
    }
}
