package LinkedList链表.Basic;
/**
 * Package Name : LinkedList链表.Basic链表;
 * File name : PartitionList86;
 * Creator: Kane;
 * Date: 8/16/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class PartitionList86 {
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode smallHead = new ListNode(0), small = smallHead;
        ListNode bigHead = new ListNode(0), big = bigHead;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                big.next = temp;
                big = big.next;
            }

            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null)))))), 3);
    }

}
