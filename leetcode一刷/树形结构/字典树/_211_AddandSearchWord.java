package 树形结构.字典树;
/**
 * Date: 10/13/20
 * Question Description
 Design a data structure that supports adding new words and finding if a string matches any previously added string.

 Implement the WordDictionary class:

 WordDictionary() Initializes the object.
 void addWord(word) Adds word to the data structure, it can be matched later.
 bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 Example:
 Input
 ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 Output
 [null,null,null,null,false,true,true,true]
 */

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
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
public class _211_AddandSearchWord {
    private TrieNode root;
    /** Initialize your data structure here. */
    public _211_AddandSearchWord() {
        root = new TrieNode();

    }

    /** Adds a word into the data structure. */
    //time complexity O(n) word.length
    //space Complexity O(num of TrieNode * 26) = O(num of words * word.length() * 26)
    public void addWord(String word) {
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
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, root, 0);

    }
    private boolean helper(String word, TrieNode node, int level) {
        if (level == word.length()) return node.isWord;
        if (word.charAt(level) == '.') {
            for (TrieNode child : node.children) {
                if (child != null && helper(word, child, level + 1)) return true;
            }
        } else {
            int j = word.charAt(level) - 'a';
            TrieNode cur = node.children[j];
            return cur != null && helper(word, cur, level + 1);
        }
        return false;
    }
}
