
package heap;
public interface IMaxHeap<E> {

    /**
     * size
     */
    int size();

    /**
     * isEmpty
     */
    boolean isEmpty();

    /**
     * 插入元素
     */
    boolean offer(E ele);

    /**
     * 删除元素
     */
    E poll();

    /**
     * peek查看栈顶
     */
    E peek();

    /**
     * print
     */
    void print();

    /**
     *
     */
    void resize(int capacity);
}
