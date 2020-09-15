package LinkedList链表.Delete;
/**
 * Package Name : LinkedList链表.Delete;
 * File name : _237_DeleteNodeinaLinkedList;
 * Creator: Kane;
 * Date: 8/18/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class _237_DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
