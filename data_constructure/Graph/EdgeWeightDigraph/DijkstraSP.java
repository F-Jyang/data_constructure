package Graph.EdgeWeightDigraph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DijkstraSP {
    public static void main(String[] args) {
        EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(6);
        edgeWeightedDigraph.addEdge(new DirectedEdge(0, 3, 23));
        edgeWeightedDigraph.addEdge(new DirectedEdge(2, 5, 214));
        edgeWeightedDigraph.addEdge(new DirectedEdge(3, 4, 21));
        edgeWeightedDigraph.addEdge(new DirectedEdge(2, 3, 244));
        edgeWeightedDigraph.addEdge(new DirectedEdge(3, 5, 223));
        edgeWeightedDigraph.addEdge(new DirectedEdge(1, 2, 212));
        edgeWeightedDigraph.addEdge(new DirectedEdge(0, 1, 12));
        edgeWeightedDigraph.addEdge(new DirectedEdge(4, 5, 10));
        DijkstraSP dijkstraSP = new DijkstraSP(edgeWeightedDigraph, 0);
        Iterable<DirectedEdge> path = dijkstraSP.pathTo(5);
        for (DirectedEdge e : path) {
            System.out.print(e.from() + " ");
        }
    }

    private DirectedEdge[] edgeTo; //到达v的边
    private double[] distTo;//从起始点到达v的距离
    private PriorityQueue<DirectedEdge> queue;//存储边

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.E()];
        distTo = new double[G.V()];
        queue = new PriorityQueue<>();
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        queue.add(new DirectedEdge(s, s, 0.0));
        while (!queue.isEmpty())
            relax(G, queue.poll().to());
    }

    /**
     * 边的松弛
     *
     * @param G
     * @param v
     */
    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                boolean flag = true;//标记是否存在到达w的边，存在则修改，不存在添加
                for (DirectedEdge edge : queue) {
                    if (edge.to() == w) {
                        queue.remove(edge);
                        queue.add(new DirectedEdge(v, w, e.weight()));
                        flag = false;
                        break;
                    }
                }
                if (flag) queue.add(new DirectedEdge(v, w, e.weight()));
            }
        }
    }

    /**
     * 到达v的最短路径
     *
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPath(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        path.add(new DirectedEdge(v, v, 0));
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.add(e);
        }

        return path;
    }

    /**
     * 到达 v 的路径长度
     *
     * @param v
     * @return
     */
    public double distTo(int v) {
        return distTo[v];
    }

    /**
     * 是否存在到达v的路径
     *
     * @param v
     * @return
     */
    public boolean hasPath(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
}
