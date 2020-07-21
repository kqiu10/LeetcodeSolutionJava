package Mylist.LinkedList;

public interface ILinkedList<E> {

    /**
     * size
     */
    int size();

    /**
     * isEmpty
     */
    boolean isEmpty();


    /**
     * add with index
     */
    void add(int index, E element);

    /**
     * add with element
     */
    boolean add(E element);

    /**
     * add at head
     */
    void addFirst(E data);

    /**
     * add at tail
     */
    void addLast(E data);

    /**
     * find
     */
    boolean contains(E ele);

    /**
     * set
     */
    void set(int idx, E ele);

    /**
     * get
     */
    E get(int index);

    /**
     * get first element
     */
    E getFirst(int index);
    /**
     * get last element
     */
    E getLast(int index);

    /**
     * delete with index
     */
    E remove(int index);

    /**
     * delete at head
     */
    E removeFirst();

    /**
     * delete at tail
     */
    E removeLast();

    /**
     * delete with element
     */
    boolean remove(E element);


    /**
     * check Index;
     */
    void validateIndex(int index);

}
