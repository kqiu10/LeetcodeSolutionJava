/**
 * Package Name : PACKAGE_NAME;
 * File name : _146LRUchche;
 * Creator: Kane;
 * Date: 9/10/20
 */

import java.util.HashMap;

/**
 *Design and implement a data structure for Least Recently Used (LRU) cache. It should support
 * the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache
 * reached its capacity, it should invalidate the least recently used item before inserting a new
 * item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * _146_LRUCache cache = new _146_LRUCache( 2 /* capacity  );
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 *
 * Time complexity:O(1);
 * Space complexity: O();
 * Description:
 * put function thinking
 *   有相同key node
 *
 *   无相同key node :   hashmap满了
 *
 *                     hashmap非满 ： hashmap无元素
 *
 *                                   hashmap有元素
 *
 *
*/
public  class _146LRUchche {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;
    public _146LRUchche(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) {
            if (node == head) {
                head.next = head;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
        }
        return node.value;

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head.next = head;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }

                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }

    }

    public static void main(String[] args) {
        _146LRUchche obj = new _146LRUchche(2);
        int param_1 = obj.get(1);
        obj.put(1,1);
        obj.put(2,2);
        obj.put(3,3);
    }
}

