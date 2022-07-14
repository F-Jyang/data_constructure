package Graph.EdgeWeightDigraph;

import Graph.Graph;

/**
 * 节点
 */
public class DirectedEdge  implements Comparable<DirectedEdge>{
    private final int v; //边的起点
    private final int w; //边的终点
    private final double weight; //权重

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(DirectedEdge edge) {
        return (int) (this.weight - edge.weight());
    }
}
