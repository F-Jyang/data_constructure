package Graph.Practice;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph(10, new String[]{"北京", "汕尾", "广州", "南京", "深圳", "汕尾", "汕头", "珠海", "东莞", "惠州"});
        graph.addEdge(new Edge(0, 1, 1, "0", "1"));
        graph.addEdge(new Edge(1, 2, 2, "2", "3"));
        graph.addEdge(new Edge(2, 4, 3, "4", "5"));
        graph.addEdge(new Edge(1, 3, 6, "2", "3"));
        graph.addEdge(new Edge(3, 4, 4, "4", "5"));
        graph.addEdge(new Edge(3, 5, 4, "7", "8"));
        graph.addEdge(new Edge(5, 6, 4, "5", "6"));
        graph.addEdge(new Edge(4, 5, 7, "6", "7"));
        DFS dfs = new DFS(graph, 0, 5);//从城市0到城市5的路线
        List<List<Edge>> res = dfs.pathTo();
        List<Edge> cheapest = dfs.getCheapest();
        System.out.println(cheapest);
        for (Edge edge : cheapest) {
            System.out.println(edge);
        }
        System.out.println(dfs.getPrice(cheapest));
    }
}
