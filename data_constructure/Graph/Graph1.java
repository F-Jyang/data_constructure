package Graph;

/*
 * 邻接表实现无向图
 */

import java.util.HashSet;

public class Graph1 {

    // 顶点类
    class VertexNode {
        int index;// 连线第一个节点
        EdgeNode headnode;

        private VertexNode(int index) {
            this.index = index;
            headnode = new EdgeNode();
        }
    }

    // 边长类
    class EdgeNode {
        int index;// 连线后一个节点
        EdgeNode next;
        int weight;

        private EdgeNode() {
        }

        private EdgeNode(int index, EdgeNode next) {
            this.index = index;
            this.next = next;
        }
    }

    VertexNode[] vertexs;
    int vertexNums;
    int edgeNums;

    // 构造方法，传入顶点与顶点之间的连线和顶点个数
    public Graph1(int[][] data, int size) {
        vertexNums = size;
        edgeNums = data.length;
        vertexs = new VertexNode[size];

        // 初始化图的顶点
        for (int i = 0; i < vertexs.length; i++) {
            vertexs[i] = new VertexNode(i);
        }

        // 将data（即图的连线）加入图中
        for (int i = 0; i < data.length; i++) {
            int head = data[i][0];// 连线的前一个结点
            int tail = data[i][1];// 连线的后一个结点
            // 头插法
            EdgeNode next = new EdgeNode(tail, vertexs[head].headnode.next);
            vertexs[head].headnode.next = next;
        }
    }

    // 遍历某个顶点的边方法，头节点不存值
    public Iterable<Integer> adj(int index) {
        HashSet<Integer> set = new HashSet<>();
        EdgeNode node = vertexs[index].headnode;

        while (node.next != null) {
            node = node.next;
            set.add(node.index);
        }
        return set;
    }

    // 测试方法
    public static void main(String[] args) {
        int[][] data = { { 0, 3 }, { 1, 0 }, { 1, 2 }, { 2, 0 }, { 2, 1 }, };
        Graph1 ald = new Graph1(data, 4);
        for (int i : ald.adj(0)) {
            System.out.println(i);
        }
        System.out.println(ald.edgeNums);
        System.out.println(ald.vertexNums);
        System.out.println(ald.vertexs[0].headnode.index);
        System.err.println(ald.vertexs[0].headnode.next.index);
    }
}

