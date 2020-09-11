package openAddressing;
/**
 * Package Name : openAddressing;
 * File name : Main;
 * Creator: Kane;
 * Date: 9/10/20
 */

import openAddressing.Impl.HashTableOpenAddressingImpl;
import separateChaining.IHashTable;
import separateChaining.impl.HashTableSeparateChainingImpl;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class Main {
    public static void main(String[] args) {
        IHashTable<Integer, Integer> hashTable = new HashTableOpenAddressingImpl<>();
        hashTable.put(1, 1);
        hashTable.put(11, 1);
        hashTable.put(21, 1);
        hashTable.put(12, 1);
        hashTable.put(22, 1);
        hashTable.print();
        hashTable.put(52, 1);
        hashTable.print();
        hashTable.delete(21);
        hashTable.print();
    }
}
