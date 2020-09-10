package leetCode.trie_14;

public class TrieNode {

    TrieNode[] children;
//    HashMap<Character, TrieNode> map; 写成HashMap也行
    boolean isWord;
    String word;

    public TrieNode() {
        children = new TrieNode[26]; //不一定26 也可能有符号, 这个数组的index就可以代表字母
        isWord = false; //判断是否是一个单词，初始化false
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        TrieNode a = new TrieNode();
        root.children[0] = a;
        for(TrieNode c : root.children) {
            System.out.println(c);
        }
    }
}
