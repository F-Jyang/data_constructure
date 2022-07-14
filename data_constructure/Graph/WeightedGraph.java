package Graph;

import java.util.LinkedList;
import java.util.List;

/*
 * 带权无向图
 */
public class WeightedGraph {
    int vertexNum;
    int edgeNum;
    LinkedList<Edge>[] graph;

    public WeightedGraph(int[][] data, int vertexNum) {
        graph = new LinkedList[vertexNum];
        this.vertexNum = vertexNum;
        this.edgeNum = data.length;

        for (int i = 0; i < vertexNum; i++) {
            graph[i] = new LinkedList<Edge>();
        }

        for (int i = 0; i < data.length; i++) {
            Edge edge = new Edge(data[i][0], data[i][1], data[i][2]);
            graph[edge.getHead()].add(edge);
            graph[edge.getTail()].add(edge);
        }
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    // 得到某个顶点的所有边
    public Iterable<Edge> adj(int vertex) {
        return graph[vertex];
    }

    // 将所有的边添加进list中
    public Iterable<Edge> getEdges() {
        List<Edge> edges = new LinkedList<Edge>();
        for (int i = 0; i < vertexNum; i++) {
            for (Edge edge : graph[i]) {
                //防止一条边添加两次，这个图没有边的重复检测方法
                if (edge.getHead() > edge.getTail() && edge.getHead() == i) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }

    public static void main(String[] args) {
        int[][] data = {{0, 1, 2}, {2, 1, 2}, {1, 2, 2}, {2, 0, 0}, {1, 2, 2}, {1, 0, 2}};
        WeightedGraph graph = new WeightedGraph(data, 3);
        for (int i = 0; i < graph.getVertexNum(); i++) {
            for (Edge edge : graph.adj(i)) {
                System.out.println(edge);
            }
            System.out.println();
        }

        for (Edge edge : graph.getEdges()) {
            System.out.println(edge);
        }
    }
}

