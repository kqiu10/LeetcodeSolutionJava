package LinkedList链表.Reverse;
/**
 * Package Name : LinkedList链表.Reverse;
 * File name : _206_ReverseLinkedList;
 * Creator: Kane;
 * Date: 8/16/20
 */

import LinkedList链表.Reverse.ListNode;
/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;

    }
}
