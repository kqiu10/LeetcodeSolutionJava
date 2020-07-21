package Mylist.LinkedList.impL;
/**
 * Description: TODO
 * Package Name : Mylist.LinkedList.impL;
 * File name : LinkedListImpl;
 * Creator: Kane;
 * Date: 7/20/20
 */

import Mylist.IMyList;
import Mylist.LinkedList.ILinkedList;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class LinkedListImpl<E> implements ILinkedList<E>, IMyList<E> {
    private int size;

    private ListNode dummy;

    public class ListNode<E> {
        public E data;
        public ListNode next;
        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListImpl() {
        this.dummy = new ListNode(0);
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
    public void add(int index, E element) {
       validateIndex(index);
        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
             prev = prev.next;
        }
        ListNode next = prev.next;
        ListNode node = new ListNode(element);
        prev.next = node;
        node.next = next;
        size++;


    }

    @Override
    public void addFirst(E data) {
        add(0,data);
    }

    @Override
    public void addLast(E data) {
        add(size,data);
    }

    @Override
    public void add(E element) {
        add(size, element);
    }
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of range");
        }
        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
             prev = prev.next;
        }
        ListNode del = prev.next;
        prev.next = del.next;
        del.next = null;
        size--;
        return (E) del.data;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size);
    }



    @Override
    public boolean remove(E element) {
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.data == element) {
               break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            ListNode del = prev.next;
            prev.next = del.next;
            del.next = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public void set(int idx, E ele) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("index out of range");
        }
        ListNode cur = dummy.next;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }
        cur.data = ele;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of range");
        }
        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
             cur = cur.next;

        }
        return (E) cur.data;
    }

    @Override
    public E getFirst(int index) {
        return get(0);
    }

    @Override
    public E getLast(int index) {
        return get(size - 1);
    }

    @Override
    public void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of range");
        }
    }

    @Override
    public boolean contains(E ele) {
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.data.equals(ele)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void print() {
        ListNode cur = dummy.next;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
