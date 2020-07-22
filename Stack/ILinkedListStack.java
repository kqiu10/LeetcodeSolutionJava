package Stack;

public interface ILinkedListStack<E> {
    /**
     * size
     */
    int size();

    /**
     * isEmpty
     */
    boolean isEmpty();

    /**
     * add with element
     */
    void push(E element);

    /**
     * delete with index
     */
    E pop();

    /**
     * print
     */
    void print();

    /**
     * peek
     */
    E peek();

}
