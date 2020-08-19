package LinkedList链表.数组相关;
/**
 * Package Name : LinkedList链表.数组相关;
 * File name : SortList148;
 * Creator: Kane;
 * Date: 8/18/20
 */

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(n);
 * Description: MergeSort
 */
public class SortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middleNode = findMiddle(head);
        ListNode next = middleNode.next;
        middleNode.next = null;
        return merge(sortList(head), sortList(next));

    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode merge (ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val > b.val) {
                cur.next = b;
                b = b.next;
            } else {
                cur.next = a;
                a = a.next;
            }
            cur = cur.next;
        }
        if (a != null) cur.next = a;
        else cur.next = b;
        return dummy.next;
    }
}
