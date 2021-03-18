package src; /**
 * Date: 11/21/20
 * Question Description
 Implement a trie with insert, search, and startsWith methods.

 Example:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true
 */

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _208_ImplementTrie {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public _208_ImplementTrie() {
        root = new TrieNode();

    }
    //time complexity O(n) word.length
    //space Complexity O(num of TrieNode * 26) = O(num of words * word.length() * 26)
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
        node.word = word;
    }
    //Time Complexity O(n)
    //Space Complexity O(1)
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                return false;
            }
            node = node.children[j];
        }
        return node.word.equals(word);

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (node.children[j] == null) {
                return false;
            }
            node = node.children[j];
        }
        return true;

    }
}
