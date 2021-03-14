/**
 * Date: 3/13/21
 * Question Description:
 * <p>
 * Examples:
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _82_RemoveDuplicatesfromSortedListII {
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicate(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int minVal = p.next.val;
                while (p.next != null && p.next.val == minVal) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;

    }
}
