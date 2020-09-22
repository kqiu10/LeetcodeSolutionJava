package src.unionFind;

public interface IUnionFind {
    /**
     * 有多少个节点
     */
    int count();

    /**
     * 两个节点融合
     */
    void union(int x, int y);

    /**
     * 找到对应的集合
     */
    int find(int index);

    /**
     * 判断是否两个点属于同一集合
     */
    boolean connected(int x, int y);
}
