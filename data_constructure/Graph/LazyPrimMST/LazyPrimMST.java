package Graph.LazyPrimMST;

import Graph.*;

import java.util.LinkedList;
import java.util.Queue;

/*
最小生成树的延时实现
 */
public class LazyPrimMST {
    private MinPQ<Edge> queue;
    private boolean[] marked;
    private Queue<Edge> mst;

    public LazyPrimMST(WeightedGraph graph) throws Exception {
        queue = new MinPQ<>(graph.getEdgeNum());
        mst = new LinkedList<>();
        marked = new boolean[graph.getVertexNum()];

        visit(graph, 0);

        //添加生成树的边，
        while (!queue.isEmpty()) {
            Edge e = queue.delMin();
            if (marked[e.getHead()] && marked[e.getTail()])
                continue;
            mst.add(e);//这里添加的是到达e的最小权重边，而不是e到达其他点的
            if (!marked[e.getHead()]) visit(graph, e.getHead());
            if (!marked[e.getTail()]) visit(graph, e.getTail());
        }
    }

    //每次visit一个点都把这个点标记为true、相关且未添加进队列的边添加进队列（另外一个顶点未访问）
    public void visit(WeightedGraph graph, int index) throws Exception {
        marked[index] = true;
        for (Edge edge : graph.adj(index)) {
            if (!marked[edge.getOtherVertex(index)]) {//防止添加两条重复的边
                queue.insert(edge);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0;
        for (Edge edge : edges()) {
            weight += edge.getWeight();
        }
        return weight;
    }

    public static void main(String[] args) throws Exception {
        int[][] data = {
                {0, 2, 2},
                {0, 1, 4},
                {0, 5, 5},
                {1, 2, 3},
                {1, 5, 11},
                {1, 3, 7},
                {2, 3, 8},
                {2, 4, 10},
                {3, 5, 6},
                {3, 4, 1},
                {4, 5, 9}
        };
        WeightedGraph wg = new WeightedGraph(data, 6);
        LazyPrimMST lpm = new LazyPrimMST(wg);
        for (Edge e : lpm.edges()) {
            System.out.println(e);
        }
    }
}
