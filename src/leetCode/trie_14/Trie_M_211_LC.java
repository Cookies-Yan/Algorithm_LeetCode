package leetCode.trie_14;

public class Trie_M_211_LC {

    TrieNode root;

    private void add(String word) {
        TrieNode cur = root; //这时候26个空间分配好了，但是每个节点还是空的，只是初始化了一下
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) { //如果该位置没有分配几点, 如果是节点属性的数组初始化的时候，所有数据额都是null
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a']; //继续往下找
        }
        cur.isWord = true; // 以Apple为例子, 到e结束
    }

    private boolean contains(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    private boolean startwtih(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    private boolean search(String word) {
        return match(root, word,0);
    }

    private boolean match(TrieNode cur, String word, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        if (word.charAt(index) == '.') {
            for (TrieNode temp : cur.children) {
                if (temp != null && match(temp, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            char c = word.charAt(index);
            TrieNode temp = cur.children[c - 'a'];
            return temp != null && match(temp, word, index + 1);
        }
    }
}
