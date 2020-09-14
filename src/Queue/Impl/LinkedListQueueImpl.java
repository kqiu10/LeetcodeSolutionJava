package Queue.Impl;
/**
 * Description: TODO
 * Package Name : Queue.Impl;
 * File name : LinkedListQueueIpmpl;
 * Creator: Kane;
 * Date: 7/23/20
 */

import Queue.IQueue;

import java.util.LinkedList;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class LinkedListQueueImpl<E> implements IQueue<E> {
    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedListQueueImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private class ListNode<E> {
        E data;
        ListNode next;
        ListNode(E data) {
            this.data = data;
            this.next = null;
        }
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
        if (tail == null) {
            tail = new ListNode(ele);
            head = tail;
        } else {
            tail.next = new ListNode(ele);
            tail = tail.next;
        }
        size++;
        return true;

    }

    @Override
    public E poll() {
        if(isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        ListNode cur = head;
        head = head.next;
        cur.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return (E)cur.data;


    }

    @Override
    public E peek() {
        return (E)head.data;
    }

    @Override
    public void print() {
        System.out.println("size is " + size);
        ListNode cur = head;
        for (int i = 0; i < size; i++) {
            System.out.print(cur.data + " -> " );
            cur = cur.next;
        }
        System.out.println("");

    }

    @Override
    public void resize(int capacity) {
        throw new IllegalArgumentException("dont have this method");
    }
}
