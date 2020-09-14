package Queue.Impl;
/**
 * Description: TODO
 * Package Name : Queue.Impl;
 * File name : ArrayOfQueueImpl;
 * Creator: Kane;
 * Date: 7/23/20
 */

import Queue.IQueue;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class ArrayOfQueueImpl<E> implements IQueue<E> {
    private  E[] data;
    private int head;
    private int tail;
    private int size;

    public ArrayOfQueueImpl() {
        this(10);
    }

    public ArrayOfQueueImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean offer(E ele) {
        if (tail == data.length) {
            resize(data.length * 2);
        }
        data[tail++] = ele;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        E cur = data[head++];
        if (head == data.length) {
            head = 0;
            tail = 0;
        }
        size--;
        return cur;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[head];
    }

    @Override
    public void print() {
        System.out.println("size : " + size);
        System.out.println("capacity : " + data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }

    @Override
    public void resize(int capacity) {
        E[] res = (E[]) new Object[capacity];
        for (int i = 0; i < tail; i++) {
            res[i] = data[i];
        }
        data = res;
    }
}
