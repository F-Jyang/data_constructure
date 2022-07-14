package Graph;

/*
 * 邻接矩阵
 * 2022.5.19.
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph3 {
    private final int V;
    private int E;
    private List<ArrayList<Integer>> adj; //每个arraylist代表一个 Vertex

    // 构造方法
    public Graph3(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
    }

    // 顶点的数量
    public int V() {
        return V;
    }

    // 边的数量
    public int E() {
        return E;
    }

    // 添加一条边
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
        E++;
    }

    // 遍历某个顶点
    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    public static int degree(Graph3 G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph3 G) {
        int max = 0;
        for (int v = 0; v < G.V; v++) {
            max = Math.max(degree(G, v), max);
        }
        return max;
    }

    // 自环个数
    public static int numberOfSelfLoops(Graph3 G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;// 每条边被标记两次
    }

    // 所有点顶额平均度数
    public static double avgDegree(Graph3 G) {
        return 2.0 * G.E() / G.V();
    }

    // 打印邻接表
    public static String toString(Graph3 G) {
        StringBuilder s = new StringBuilder();
        for (int v = 0; v < G.V(); v++) {
            s.append(v).append(" : ");
            for (int w : G.adj(v)) {
                s.append(w).append(" ");
            }
            s.append('\n');
        }
        return s.toString();
    }
}
