package leetCode.trie_14;

import java.util.ArrayList;
import java.util.List;

public class H_212_WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        //floorfill思想
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j]; //用作还原
        // cur.children[c - 'a'] == null，是为了检验能否达到tree. 及只有前一半相似，后面没有了
        if (c == '#' || cur.children[c - 'a'] == null) return; //走过了就替换成'#'， 但是第二个单词可能也会用到，所以需要还原
        cur = cur.children[c - 'a']; //进入下一层tree

        if (cur.word != null) { //当word,有值的时候才是找到了
            res.add(cur.word);
            cur.word = null; //不能重复的添加
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, cur, res);
        dfs(board, i + 1, j, cur, res);
        dfs(board, i, j - 1, cur, res);
        dfs(board, i, j + 1, cur, res);
        board[i][j] = c;


    }

    private TrieNode buildTrie(String[] words) { //把一个word list都遍历
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a']; //继续往下找
            }
            cur.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children;
        String word; //不能是 this.word = this因为word完全可能是空值
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
