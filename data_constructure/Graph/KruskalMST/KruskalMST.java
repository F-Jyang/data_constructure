package Graph.KruskalMST;

import Graph.Edge;
import Graph.WeightedGraph;

import java.util.LinkedList;
import java.util.Queue;

public class KruskalMST {
    private Queue<Edge> mst; //存储最小生成树的边
    UF uf;

    public KruskalMST(WeightedGraph graph) {
        mst = new LinkedList<>();
        uf = new UF(graph.getVertexNum());
        MinPQ<Edge> pq = new MinPQ<Edge>(graph.getEdgeNum());

        //将所有的边添加到最小堆中
        for (Edge e : graph.getEdges()
        ) {
            pq.insert(e);
        }

        //将最小堆的边取出，加入生成树中
        while (!pq.isEmpty() && mst.size() < graph.getVertexNum() - 1) {
            Edge edge = pq.delMin();
            //判断边边是否构成回环（union-find算法）
            if (uf.connected(edge.getHead(), edge.getTail())) continue;
            mst.add(edge);
            uf.union(edge.getHead(), edge.getTail());
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return 0;
    }
}