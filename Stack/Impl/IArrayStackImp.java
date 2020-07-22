package Stack.Impl;
/**
 * Description: TODO
 * Package Name : Stack.Impl;
 * File name : IArrayStack;
 * Creator: Kane;
 * Date: 7/22/20
 */

import java.util.EmptyStackException;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class IArrayStackImp<E> implements Stack.IArrayStack<E> {
    private E[] data;
    private int elementCount;

    public IArrayStackImp() {
        this(10);
    }

    public IArrayStackImp(int capacity) {
        this.data = (E[])new Object[capacity];
        this.elementCount = 0;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public void push(E ele) {
        if (elementCount == data.length) {
            resize(data.length *2);
        }
        data[elementCount++] = ele;

    }

    @Override
    public E pop() {
        if (elementCount == 0) {
            new EmptyStackException();
        }
        E obj = peek();
        elementCount --;
        if (elementCount < data.length / 4) {
            resize(data.length / 2);
        }
        return obj;
    }

    @Override
    public E peek() {
        if (elementCount == 0) {
            new EmptyStackException();
        }
        return data[elementCount - 1];
    }

    @Override
    public void print() {
        System.out.println("size is " + elementCount);
        System.out.println("capacity is " + data.length);
        for (int i = elementCount - 1; i >=0; i--) {
            System.out.print(data[i] + " ");

        }

    }

    @Override
    public void resize(int capacity) {
        E[] newStack = (E[])new Object[capacity];
        for (int i = 0; i < elementCount; i++) {
            newStack[i] = data[i];
        }
        data = newStack;
    }
}
