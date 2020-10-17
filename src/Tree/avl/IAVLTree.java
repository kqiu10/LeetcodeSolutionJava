package Tree.avl;

public interface IAVLTree {
    AVLNode add(AVLNode node, int val);


    int size();

    boolean isEmpty();
    void remove(int vak);
}
