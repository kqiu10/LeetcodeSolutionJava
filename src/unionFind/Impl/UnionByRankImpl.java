package src.unionFind.Impl;
/**
 * Date: 9/21/20
 * Question Description
 */

import src.unionFind.IUnionFind;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class UnionByRankImpl implements IUnionFind {
    /**
     * 节点个数
     */
    int count;

    /**
     * 权重
     */
    int[] rank;
    /**
     * 节点
     */
    private int[] parent;


    public UnionByRankImpl(int count) {
        this.count = count;
        parent = new int[count];
        this.rank = new int[count];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    //O(N)
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        }  else {
            parent[yRoot] = xRoot;
            rank[xRoot] ++;
        }

    }

    @Override
    //O(1)
    public int find(int index) {
        if (index < 0 || index > parent.length) {
            throw new IllegalArgumentException("越界");
        }
        while (index != parent[index]) {
            index = parent[index];
        }
        return index;
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
