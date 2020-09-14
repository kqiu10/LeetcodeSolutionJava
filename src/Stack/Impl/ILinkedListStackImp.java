package Stack.Impl;
/**
 * Description: TODO
 * Package Name : Stack.Impl;
 * File name : ILinkedList;
 * Creator: Kane;
 * Date: 7/22/20
 */

import Stack.ILinkedListStack;

import java.util.LinkedList;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class ILinkedListStackImp<E> implements ILinkedListStack<E> {

    private LinkedList<E> linkedList;

    public ILinkedListStackImp() {
        this.linkedList = new LinkedList<>();
    }



    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E element) {
        linkedList.addFirst(element);

    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public void print() {
        System.out.println("size : " + linkedList.size());
        for (int i = 0; i <linkedList.size(); i++) {
            System.out.println(linkedList.get(i) + " ");
        }
        System.out.println();

    }

    @Override
    public E peek() {
        return linkedList.peekFirst();
    }
}
