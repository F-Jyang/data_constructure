package Graph.Practice;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int sum_vertex;
    int sum_edges;
    List<List<Edge>> list_edge;
    String[] cities;

    public Graph(int v, String[] cities) {
        sum_edges = 0;
        this.sum_vertex = v;
        list_edge = new ArrayList<>();
        this.cities = cities;
        for (int i = 0; i < v; i++) {
            list_edge.add(new ArrayList<>());
        }
    }

    //添加边
    public void addEdge(Edge e) {
        list_edge.get(e.from()).add(e);
        sum_edges++;
    }

    //添加节点
    public void addVertex(Vertex v) {
        list_edge.add(new ArrayList<>());
        sum_vertex++;
    }

    public List<Edge> getEdges(int v) {
        return list_edge.get(v);
    }

    public int sum_vertex() {
        return sum_vertex;
    }

    public int sum_edges() {
        return sum_edges;
    }
}
