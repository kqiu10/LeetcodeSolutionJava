package LinkedList链表.Delete;
/**
 * Package Name : LinkedList链表.Delete;
 * File name : _83_RemoveDuplicatesfromSortedList;
 * Creator: Kane;
 * Date: 8/18/20
 */
import LinkedList链表.Delete.ListNode;
/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 * in while loop we need to use cur.next.val, if cur.next == null it will throw an error, so we need use cur.next != null as situation.
 */
public class _83_RemoveDuplicatesfromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else cur = cur.next;

        }
        return head;

    }

    public static void main(String[] args) {
        deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2))));
    }
}
