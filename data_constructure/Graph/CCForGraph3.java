package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CCForGraph3 {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CCForGraph3(Graph3 graph3) {
        this.marked = new boolean[graph3.V()];
        this.id = new int[graph3.V()];
        this.count = 0;
      /*  //广度优先实现
        bfs(graph3);*/

        // 深度优先搜索
        for (int v = 0; v < id.length; v++) {
            if(marked[v])continue;
            count++;
            dfs(graph3,v);
        }
    }

    public boolean isConnected(int v, int w) {
        return id[w] == id[v];
    }

    /**
     * 广度优先遍历实现流通量
     * @param graph3
     */
    private void bfs(Graph3 graph3){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < id.length; i++) { //主要用于控制不同流通量的遍历
            if (marked[i])continue;
            queue.add(i);
            count++;
            while (!queue.isEmpty()) {//控制一个流通量内不同的节点的遍历
                Integer temp = queue.poll();
                if (marked[temp])continue;
                id[temp] = count;
                marked[temp] = true;
                for (int w:graph3.adj(temp)) {
                    queue.add(w);
                }
            }
        }
    }

    private void dfs(Graph3 graph3, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph3.adj(v)) {
            if (!marked[w]) {
                dfs(graph3, w);
            }
        }
    }
}
