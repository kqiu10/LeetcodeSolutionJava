package LinkedList链表.Basic;
/**
 * Package Name : LinkedList链表.Basic链表;
 * File name : SwapNodesInPairs24;
 * Creator: Kane;
 * Date: 8/16/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class SwapNodesInPairs24 {
     public ListNode swapPairs(ListNode head) {
         if (head == null || head.next == null) return head;
         ListNode dummy = new ListNode(0);
         ListNode l1 = dummy;
         ListNode l2 = head;
         while (l2 != null && l2.next != null) {
             ListNode nextStart = l2.next.next;
             l1.next = l2.next;
             l2.next.next = l2;
             l2.next = nextStart;
             l1 = l2;
             l2 = l2.next;
         }
         return dummy.next;


     }

}
