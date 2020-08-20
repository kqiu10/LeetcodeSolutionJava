package Random随机.基础;
/**
 * Package Name : Random随机.基础;
 * File name : LinkedListRandomNode382;
 * Creator: Kane;
 * Date: 8/20/20
 */

import LinkedList链表.Basic.ListNode;

import java.util.Random;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class LinkedListRandomNode382 {
    ListNode head;
    Random rnd;
    public LinkedListRandomNode382(ListNode head) {
        this.head = head;
        rnd = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = head;
        int res = temp.val;
        int count = 1;
        while (temp.next != null) {
            temp  = temp.next;
            if (rnd.nextInt(++count) == 0) {
                res = temp.val;
            }
        }
        return res;
    }
}
