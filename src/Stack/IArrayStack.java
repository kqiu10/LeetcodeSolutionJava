package Stack;

public interface IArrayStack<E> {
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
     * push
     */
    void push(E ele);

    /**
     * pop
     */
    E pop();

    /**
     * peek查看栈顶
     */
    E peek();

    /**
     * print
     */
    void print();

    /**
     * lazy reisez;
     */
    void resize(int capacity);
}
