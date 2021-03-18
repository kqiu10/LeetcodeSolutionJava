package src; /**
 * Date: 11/22/20
 * Question Description
 */

/**
 * Description: TODO

 */
public class _211_DesignAddandSearchWOrdsDataStructure {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }
    /** Initialize your data structure here. */
    private TrieNode root;
    public _211_DesignAddandSearchWOrdsDataStructure() {
        root = new TrieNode();
    }
    //time complexity O(n) word.length
    //space Complexity O(num of TrieNode * 26) = O(num of words * word.length() * 26)
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }
            node = node.children[c];
        }
        node.word = word;
        node.isWord = true;
    }
    //Time Complexity O(n)
    //Space Complexity O(1)
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word, 0);
    }
    private boolean helper(TrieNode node, String word, int level) {
        if (level == word.length()) return node.isWord;
        if (word.charAt(level) == '.') {
            for (TrieNode child : node.children) {
                if (child != null && helper(child, word, level + 1)) return true;
            }
        } else {
            int j = word.charAt(level) - 'a';
            TrieNode cur = node.children[j];
            return cur != null && helper(cur, word, level + 1);
        }
        return false;
    }
}
