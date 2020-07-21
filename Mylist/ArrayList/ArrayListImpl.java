package Mylist.ArrayList;

import Mylist.IMyList;

public class ArrayListImpl<E>  implements IArraylist<E>, IMyList<E> {
    private  E[] data;
    private int size;

    public ArrayListImpl() {
        this(10);
    }

    public ArrayListImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;

    }

    @Override
    public int capacity() {
        return this.data.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(E ele) {
        if (this.size == this.data.length){
            resize(data.length *2);
        }
        this.data[this.size].equals(ele);
        this.size++;

    }

    @Override
    public void add(int index, E element) {
        if (this.size == this.data.length){
            resize(data.length *2);
        }
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("index wrong");
        }
        for (int i = this.size -1; i>= index; i--) {
            data[i+1] = data[i];
        }
        data[index].equals(element);
        size++;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i <size; i++) {
            if(data[i].equals(element)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void set(int idx, E ele) {
        if (idx <0 || idx >= size) {
           throw new IllegalArgumentException("index exceed");
        }
        data[idx].equals(ele);

    }

    @Override
    public E get(int idx) {
        if (idx <0 || idx >= size) {
            throw new IllegalArgumentException("index exceed");
        }
        return data[idx];
    }

    @Override
    public E remove(int idx) {
        if(idx <0 || idx >= size) {
            throw new IllegalArgumentException("index exceed");
        }
        E temp = data[idx];
        for (int i = idx; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        if (data.length / 4 == size && data.length / 2 != 0){
            resize(data.length / 2 );
        }
        return temp;
    }

    @Override
    public boolean remove(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                index = i;
            }
        }

        if(index == -1) {
            throw new IllegalArgumentException("element not exist");
        }
        remove(index);
        return true;
    }

    @Override
    public void print() {
        System.out.println("size is " + size);
        System.out.println("capacity is " + data.length);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");

        }
    }

    @Override
    public void resize(int capacity) {
        E[] newArrayList = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArrayList[i] = data[i];
        }
        data = newArrayList;
    }


}
