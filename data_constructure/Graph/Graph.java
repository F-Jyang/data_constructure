package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
/*
 * 邻接矩阵实现
 */
public class Graph {
	private int[][] edges;//边长数
	private ArrayList<String> vertexList;//存储顶点集合
	private int numOfEdges;
	private boolean[] isVisited;

	//构造函数
	public Graph(int n) {
		edges=new int[n][n];
		vertexList=new ArrayList<String>(n);
		numOfEdges=0;
		isVisited=new boolean[n];
	}

	//得到第一个邻接节点的下标w
	public int getFirstNeighbor(int index) {
		for (int i = 0; i < vertexList.size(); i++) {
			if(edges[index][i]>0) {
				return i;
			}
		}
		return -1;
	}

	//根据前一个邻接结点的下标来获取下一个邻接结点
	public int getNextNeighbor(int v1,int v2) {
		for (int i = v2+1; i < vertexList.size(); i++) {
			if(edges[v1][i]>0) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * 过程：1、将访问过的结点设置为true，然后寻找它的下一个结点。
	 * 		2、如果下一个结点存在，则进入while循环，在while循环里面判断该节点是否被访问过，
	 * 		   没有则深度优先搜索该节点。被访问过则得到上一个结点在该结点之后的下一个结点（也就是上一个结点的第二个邻接结点）。
	 * 		3、如果下一个结点存在，则继续进入2步骤，不存在则结束循环，方法结束。
	 */
	private void dfs(boolean[] isVisited,int i) {
		System.out.print(getValueByIndex(i)+",");
		//将节点设置为已访问
		isVisited[i]=true;
		//查找节点的邻接结点
		int w=getFirstNeighbor(i);
		while(w!=-1) {//说明有节点
			if(!isVisited[w]) {
				dfs(isVisited,w);
			}
			//如果w节点已经被访问过，则寻找该结点后的下一个结点
			w=getNextNeighbor(i, w);
		}
	}

	//对dfs进行一个重载，遍历我们所有的节点，并进行dfs
	public void dfs() {
		isVisited=new boolean[vertexList.size()];
		//遍历所有节点，进行dfs【回溯】
		for (int i = 0; i < getNumOfVertex(); i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i);
			}
		}
	}

	//对一个节点进行广度优先遍历的方法
	private void bfs(boolean[] isVisited ,int i) {
		int u;//表示队列的头节点对应下标
		int w;//邻接结点w
		//队列，记录节点的头节点对应下标
		LinkedList queue=new LinkedList();
		System.out.println(getValueByIndex(i)+",");
		//标记已访问
		isVisited[i]=true;
		//将结点加入队列
		queue.addLast(i);

		while(!queue.isEmpty()) {
			//去除队列的头节点下标
			u=(Integer)queue.removeFirst();
			//得到第一个邻接结点的下标w
			w=getFirstNeighbor(u);
			while(w!=-1) {
				//是否访问过
				if(!isVisited[w]) {
					System.err.println(getValueByIndex(w)+",");
					//标记已经访问
					isVisited[w]=true;
					//入队
					queue.addLast(w);
				}

				w=getNextNeighbor(u, w);//体现我们的广度优先搜索
			}
		}
	}

	//广度优先搜索所有的结点
	public void bfs() {
		isVisited=new boolean[vertexList.size()];
		for (int i = 0; i < getNumOfVertex(); i++) {
			if(!isVisited[i]) {
				bfs(isVisited,i);
			}
		}
	}

	//常用方法
	public int getNumOfVertex() {
		return vertexList.size();
	}

	//得到边数目
	public int getNumOfEdges() {
		return numOfEdges;
	}

	//通过索引得到节点
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}

	//得到权重
	public int getWeight(int v1,int v2) {
		return edges[v1][v2];
	}

	//插入顶点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}

	//插入边
	public void insertEdge(int v1,int v2,int weight) {
		edges[v1][v2]=weight;
		edges[v2][v1]=weight;
		numOfEdges++;
	}

	//展示图
	public void showGraph() {
		for (int[] link:edges) {
			System.out.println(Arrays.toString(link));
		}
	}


}
