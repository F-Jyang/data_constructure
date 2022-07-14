package Graph.Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * #Description 航班图
 *
 * @author Jyang.
 * #Date 2022/7/5
 */
public class DFS {
    Graph graph;//传入图
    int sum_vertex;
    int sum_edge;
    int s;//起点
    int w;//终点
    List<List<Edge>> res;//结果集
    String[] cities;

    public DFS(Graph graph, int s, int w) {
        this.graph = graph;
        this.sum_vertex = graph.sum_vertex();
        this.sum_edge = graph.sum_edges();
        this.s = s;
        this.w = w;
        this.res = new ArrayList<>();
        this.cities = new String[graph.sum_vertex()];
        dfs();
    }

    /**
     * dfs得到所有路线
     */
    public void dfs() {
        List<Edge> list = new ArrayList<>();
        for (Edge edge : graph.getEdges(s)) {
            list.add(edge);
            dfs(list, edge);
            list.remove(list.size() - 1);
        }
    }

    private void dfs(List<Edge> list, Edge e) {
        if (e.to() == this.s) return;
        if (e.to() == this.w) {
            List<Edge> temp = new ArrayList<>();
            for (Edge edge : list) {
                temp.add(edge);
            }
            res.add(temp);
            return;
        }
        for (Edge edge : graph.getEdges(e.to())) {
            Edge edge_tmp = list.get(list.size() - 1);
            if (edge_tmp.arriveTime().compareTo(edge.leaveTime()) >= 0) continue;
            list.add(edge);
            dfs(list, edge);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 得到所有路线
     *
     * @return
     */
    public List<List<Edge>> pathTo() {
        return res;
    }

    /**
     * 路线总价格
     *
     * @param edges
     * @return
     */
    public double getPrice(List<Edge> edges) {
        double sum = 0;
        for (Edge edge : edges) {
            sum += edge.weight();
        }
        return sum;
    }

    /**
     * 得到最便宜价格的路线
     *
     * @return
     */
    public List<Edge> getCheapest() {
        double cheap = Double.POSITIVE_INFINITY;
        List<Edge> list_cheap = null;
        for (List<Edge> list : res) {
            double price = getPrice(list);
            list_cheap = getPrice(list) < cheap ? list : list_cheap;
            cheap = Math.min(cheap, price);
        }
        return list_cheap;
    }
}
