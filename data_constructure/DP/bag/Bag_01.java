package DP.bag;

/**
 * 背包问题：最重要的是自己手推一遍结果
 */
public class Bag_01 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        testweightbagproblem(weight, value, bagsize);
    }
    public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {
        //1、数组下标的含义
        /*
        表示从0-i个背包中，在重量为j的情况下，取得的最大价值
         */
        int wlen=weight.length;
        int[][] dp=new int[wlen+1][bagsize+1];
        //2、数组的初始化
        /*
        背包为0或者容量为0时均初始化为0
         */
        int value0=0;
        for (int i = 0; i < wlen; i++) {
            dp[i][0]=value0;
            dp[0][i]=value0;
        }
        //3、递推公式
        /*
        dp[i-1][j]
        dp[i-1][j-weight[i-1]]+value[i-1]
         */
        //4、遍历顺序
        /*
        不论先遍历背包还是先遍历重量都可以
         */
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if(j<weight[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        //5、模拟验证准确性
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
