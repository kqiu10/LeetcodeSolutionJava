package Queue.Impl;
/**
 * Description: TODO
 * Package Name : Queue.Impl;
 * File name : ArrayCircularOfQueueImpl;
 * Creator: Kane;
 * Date: 7/23/20
 */

import Queue.IQueue;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class ArrayCircularOfQueueImpl<E> implements IQueue<E> {
    E[] data;
    int front;
    int rear;

    public ArrayCircularOfQueueImpl() {
        this(10);
    }

    public ArrayCircularOfQueueImpl(int capacity) {
        this.data = (E[])new Object[capacity];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public int size() {
        return (rear - front + data.length) % data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean offer(E ele) {
        data[rear] = ele;
        if ((rear = (rear + 1) % data.length) == front) {
            resize(data.length * 2);
        }
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        return res;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    @Override
    public void print() {
        System.out.println("size : " + size());
        System.out.println("capacity : " + data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");

    }

    @Override
    public void resize(int capacity) {
        E[] res = (E[])new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            res[i] = data[(i + front) % data.length];
        }
        front = 0;
        rear = data.length;
        data = res;
    }
}
