package UninoFind.UnionFind;

public class UF {
    private int count;
    private int id[];

    public UF(int sum) {
        id = new int[sum];
        count = sum;
        for (int i = 0; i < sum; i++) {
            id[i] = i;
        }
    }

    public int find(int index) {
        if (id[index] == index) return index;
        return find(id[index]);
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int getCount() {
        return count;
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) return;
        for (int i = 0; i < count; i++) {
            if (find(i) == pid) id[i] = qid;
        }
        count--;
    }
}

