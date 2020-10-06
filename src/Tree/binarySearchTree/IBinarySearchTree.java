package Tree.binarySearchTree;

public interface IBinarySearchTree {
    void add(int val);

    void remove(int val);

    boolean contains(int val);

    int size();

    boolean isEmpty();
}
