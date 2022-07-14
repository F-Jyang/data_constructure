package DFS;
/*
1、创建一个方法1用来遍历岛屿的数量,参数：一个二维数组，返回值：岛屿的数量
2、传入一个二维数组，调用dfs方法。参数：二维数组，当前的行和列。返回值：void
3、方法1内：遍历数组中的所有数,遇到不为0的数则岛屿数量++，并且调用dfs方法让它普遍的岛屿变成0
4、dfs方法内：先定位到当前这个数，递归得到前后左右的数，如果前后左右为岛屿，则变为0再次递归
 */


public class Solution {
    public static void main(String[] args) {
        char[][] world={{'1',1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        Solution s=new Solution();
        System.out.println(s.numOfIsland(world));
    }
    int num_island = 0;

    public int numOfIsland(char[][] island) {
        int row = island.length;//行数
        int col = island[0].length;//列数
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[0].length; j++) {
                if (island[i][j] == 1) {
                    num_island++;
                    DFS(island, i, j);
                }
            }
        }
        return num_island;
    }

    //2、传入一个二维数组，调用dfs方法。参数：二维数组，当前的行row和列column。返回值：void
    private void DFS(char[][] island, int r, int c) {
        //4、dfs方法内：先判断当前数是否索引越界，
        // 然后定位到当前这个数并让它等于0，递归得到前后左右的数，如果前后左右为岛屿，则再次递归令其等于0
        int row=island.length;
        int col=island[0].length;
        if(r<0||c<0||r>=row||c>=col||island[r][c]==0)return;//结束条件:索引越界或者当前的数为0
        island[r][c]=0;
        //指定一个方向优先，在该方向的递归没结束前不会进入下一个方向，所以是深度优先搜索
        if(r-1>=0&&island[r-1][c]!=0){
            DFS(island,r-1,c);
        }
        if(r+1<row&&island[r+1][c]!=0){
            DFS(island,r+1,c);
        }
        if(c-1>=0&&island[r][c-1]!=0){
            DFS(island,r,c-1);
        }
        if(c+1<col&&island[r][c+1]!=0){
            DFS(island,r,c+1);
        }
    }
}

