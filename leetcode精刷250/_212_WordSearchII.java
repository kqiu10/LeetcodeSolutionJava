/**
 * Date: 11/22/20
 * Question Description
 class TrieNode {
 TrieNode[] children;
 String word;

 public TrieNode() {
 children = new TrieNode[26];
 word = null;
 }
 }
 private TrieNode buildTrie(String[] words) {
 TrieNode root = new TrieNode();
 for (String word : words) {
 TrieNode c = root;
 for (char ch : word.toCharArray()) {
 int j = ch - 'a';
 if (c.children[j] == null) {
 c.children[j] = new TrieNode();
 }
 c = c.children[j];
 }
 c.word = word;
 }
 return root;
 }
 public List<String> findWords(char[][] board, String[] words) {
 List<String> res = new ArrayList<>();
 TrieNode root = buildTrie(words);
 for (int i = 0; i < board.length; i++) {
 for (int j = 0; j < board[0].length; j++) {
 dfs(board, res, i, j, root);
 }
 }
 return res;
 }

 private void dfs(char[][] board, List<String> res, int i, int j, TrieNode node) {
 if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
 char c = board[i][j];
 if (c == '#' || node.children[c - 'a'] == null) return;
 node = node.children[c - 'a'];
 if (node.word != null) {
 res.add(node.word);
 node.word = null;
 }
 board[i][j] = '#';
 dfs(board, res, i - 1, j, node);
 dfs(board, res, i + 1, j, node);
 dfs(board, res, i, j - 1, node);
 dfs(board, res, i, j + 1, node);
 board[i][j] = c;
 }
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(m * n * TrieNode);
 * Space complexity: O(TrieNode);

 */
public class _212_WordSearchII {
    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode c = root;
            for (char ch : word.toCharArray()) {
                int j = ch - 'a';
                if (c.children[j] == null) {
                    c.children[j] = new TrieNode();
                }
                c = c.children[j];
            }
            c.word = word;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, res, i, j, root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, List<String> res, int i, int j, TrieNode node) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        dfs(board, res, i - 1, j, node);
        dfs(board, res, i + 1, j, node);
        dfs(board, res, i, j - 1, node);
        dfs(board, res, i, j + 1, node);
        board[i][j] = c;
    }

}
