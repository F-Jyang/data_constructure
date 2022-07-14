package DFS;

import java.util.LinkedList;
import java.util.Queue;

/*
1、从0.0开始，将四周的点添加进队列中
2、
 */
public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isflag=false;
        for (int[] ints : matrix) {
            if (isflag) break;
            for (int anInt : ints) {
                if (anInt == target) {
                    isflag = true;
                    break;
                }
            }
        }
        return isflag;
    }
}