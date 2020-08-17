package LinkedList链表.Basic;
/**
 * Package Name : LinkedList链表.Basic链表;
 * File name : OddEvenLinkedList328;
 * Creator: Kane;
 * Date: 8/16/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class OddEvenLinkedList328 {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;


    }

    public static void main(String[] args) {
        oddEvenList(new ListNode(0, new ListNode (5, new ListNode( 10 , null))));
    }
}
