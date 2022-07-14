package Graph.EdgeWeightDigraph;

import Graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
    public static void main(String[] args) {
        EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(2);
        for (int i = 0; i < edgeWeightedDigraph.V; i++) {
            System.out.println(edgeWeightedDigraph.adj.get(i));
        }

    }

    private final int V;//顶点个数
    private int E;//边的条数
    private final List<List<DirectedEdge>> adj;//邻接表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 添加边
     * @param e
     */
    public void addEdge(DirectedEdge e) {
        adj.get(e.from()).add(e);
        E++;
    }

    /**
     * 获取v指出的边
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v){
        return adj.get(v);
    }
    /**
     * 获取所有的边
     * @return
     */
    public Iterable<DirectedEdge> edges(){
        List<DirectedEdge> list = new ArrayList<>();
        for (List<DirectedEdge> directedEdges : adj) {
            int size = directedEdges.size();
            for (DirectedEdge directedEdge : directedEdges) {
                list.add(directedEdge);
            }
        }
        return list;
    }
}
