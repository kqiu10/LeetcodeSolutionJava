package Mylist.LinkedList;
/**
 * Description: TODO
 * Package Name : Mylist.LinkedList;
 * File name : Main;
 * Creator: Kane;
 * Date: 7/20/20
 */

import Mylist.LinkedList.impL.LinkedListImpl;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class Main {
    public static void main(String[] args) {
        ILinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.print();
        linkedList.add(0,5);
        linkedList.print();
        linkedList.remove(0);
        linkedList.print();
    }
}
