package UninoFind.QuickUninoFind;

/*
Union-Find：并查集,用来判断两个分量是否连通
 */
public class QUF {
    private int count;//分量的数量
    private int[] id;//触点的根节点（分量的id）

    public QUF(int sum) {//初始化分量数组
        count = sum;
        id = new int[sum];
        for (int i = 0; i < sum; i++) {
            id[i] = i;
        }
    }

    public int find(int index) {//寻找分量的id（根节点）
        return id[index];
    }

    public boolean connected(int p, int q) {//两个分量是否连通
        return find(p) == find(q);
    }

    /**
     * #Description 将两个分量连接
     *
     * @param 分量p 分量q
     * @return void
     * @author jiongyang
     * #Date 2021/12/7
     */
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (qid == pid) return;//在相同的分量，不连接
        for (int i = 0; i < id.length; i++) {//遍历，所有分量的根结点为pid的改为qip
            if (find(i) == pid) id[i] = qid;
        }
        count--;//分量数量减1
    }
}
