package LinkedList链表.Delete;
/**
 * Package Name : LinkedList链表.Delete;
 * File name : DeleteNodeinaLinkedList237;
 * Creator: Kane;
 * Date: 8/18/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class DeleteNodeinaLinkedList237 {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
