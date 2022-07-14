package Graph;

import java.util.HashSet;

/*
 * 邻接矩阵实现无向图
 */
public class Graph2 {
    int[][] graph;
    int vertexNums;
    int EdgeNums;

    public Graph2(int[][] data, int size) {

        EdgeNums = data.length;
        vertexNums = size;

        // 将所有没有连接的顶点设置为integer最大值（开始默认全部未连接）
        graph = new int[size][size];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        // 将data（连线）添加进图中
        for (int i = 0; i < data.length; i++) {
            int head = data[i][0];
            int tail = data[i][1];
            graph[head][tail] = 1;
            graph[tail][head] = 1;
        }
    }

    // 迭代器
    public Iterable<Integer> adj(int index) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i] != Integer.MAX_VALUE) {
                set.add(i);
            }
        }
        return set;
    }

    // 测试程序
    public static void main(String[] args) {
        int[][] data = { { 0, 3 }, { 1, 0 }, { 1, 2 }, { 2, 0 }, { 2, 1 }, };
        Graph2 wd = new Graph2(data, 4);
        for (int i : wd.adj(1)) {
            System.out.println(i);
        }
    }
}
