package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 图的两种遍历方法
 */
public class Search {
    //深度优先遍历
    public void DFS(Graph1 graph,int index) {
        boolean[] isVisited=new boolean[graph.vertexNums];
        DFS(graph, index,isVisited);
    }
    private void DFS(Graph1 graph,int index,boolean[] isVisited) {
        isVisited[index]=true;
        for (int vertex:graph.adj(index)) {
            if(!isVisited[vertex]) {
                DFS(graph, vertex,isVisited);
            }
        }
    }

    //广度优先遍历
    public void BFS(Graph1 graph,int index) {
        boolean[] isVisited=new boolean[graph.vertexNums];
        isVisited[index]=true;
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(index);

        //以队列中是否还有元素为条件进行循环
        while(!queue.isEmpty()) {
            //遍历顶点（在树种则是遍历左右结点）
            for (Integer vertex : graph.adj(queue.poll())) {
                if(!isVisited[vertex]) {
                    queue.offer(vertex);
                    isVisited[vertex]=true;
                }
            }
        }
    }
}

