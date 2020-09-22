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
public class UnionByWeightImpl implements IUnionFind {
    /**
     * 节点个数
     */
    int count;

    /**
     * 权重
     */
    int[] size;
    /**
     * 节点
     */
    private int[] parent;


    public UnionByWeightImpl(int count) {
        this.count = count;
        parent = new int[count];
        this.size = new int[count];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
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
        if (size[xRoot] < size[yRoot]) {
            parent[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else {
            parent[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
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
