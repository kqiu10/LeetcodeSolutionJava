package LinkedList链表.Basic链表;
/**
 * Package Name : LinkedList链表.Basic链表;
 * File name : OddEvenLinkedList328;
 * Creator: Kane;
 * Date: 8/16/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class OddEvenLinkedList328 {
    class ListNode {
        int val;
        SwapNodesInPairs24.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, SwapNodesInPairs24.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode oddEvenList(ListNode head) {
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
}
