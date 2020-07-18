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
     */
    void add(int index, int element);

    /**
     * find
     */
    boolean contains(int ele);

    /**
     * set
     */
    void set(int idx, int ele);

    /**
     * get
     */
    int get(int index);

    /**
     * delete
     */
    int remove(int index);
    void removeElement(int element);
}
