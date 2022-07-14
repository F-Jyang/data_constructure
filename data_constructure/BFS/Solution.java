package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
广度优先搜索：
1、定义两个方法，一个是直接调用的方法，一个是BFS方法
2、调用的方法：一次遍历所有的数，遇到岛屿就调用BFS方法，搜索所有的相邻岛屿
3、BFS方法：令当前岛屿等于0，寻找四周岛屿，令四周的岛屿等于0，此时借助栈
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {//行数
            for (int j = 0; j < grid[0].length; j++) {//列数
                if(grid[i][j]=='1'){
                    BFS(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    //3、BFS方法：令当前岛屿等于0，寻找四周岛屿，令四周的岛屿等于0，此时借助栈
    private void BFS(char[][] grid, int row, int col){
        //创建一个栈，用来存放四周的海或者岛屿，用数组是为了方便得到r和c
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{row,col});//添加扔进来的岛屿
        while(!queue.isEmpty()){//通过判断是否为空，进行广度优先搜索
            //将第一个出去的岛屿/海的横纵坐标得到，用来添加它四周的岛屿/海
            int[] temp=queue.remove();
            int r=temp[0];
            int c=temp[1];
            //判断是否为岛屿，岛屿的话把四周添加进队列，不是岛屿则不添加，回到while循环直到队列里没有元素
            //这样当得到的不是岛屿的时候队列书减一，最后队列的全部元素都被移除
            if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]=='1'){
                grid[row][col]=0;//令当前的岛屿为0
                queue.add(new int[]{r+1,c});
                queue.add(new int[]{r-1,c});
                queue.add(new int[]{r,c+1});
                queue.add(new int[]{r,c-1});
            }
        }
    }
}
