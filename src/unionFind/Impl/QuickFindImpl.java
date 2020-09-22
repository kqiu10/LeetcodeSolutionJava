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
public class QuickFindImpl implements IUnionFind {
    /**
     * 节点个数
     */
    int count;

    /**
     * 节点
     */
    private int[] id;


    public QuickFindImpl(int count) {
        this.count = count;
        id = new int[count];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    //O(N)
    public void union(int x, int y) {
        int A = find(x);
        int B = find(y);
        if (A == B) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == A) {
                id[i] = B;
            }
        }
        return;
    }

    @Override
    //O(1)
    public int find(int index) {
        if (index < 0 || index > id.length) {
            throw new IllegalArgumentException("越界");
        }
        return id[index];
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
