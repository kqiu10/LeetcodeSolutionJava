package src.mylist;

public interface IMylist {
    /**
     * capacity
     */
    int capacity();

    /**
     * size
     */
    int size();

    /**
     * isEmpty
     */
    boolean isEmpty();

    /**
     * add to tail
     */
    void add(int ele);

    /**
     * add anywhere
     */void add(int index, int element);
}
