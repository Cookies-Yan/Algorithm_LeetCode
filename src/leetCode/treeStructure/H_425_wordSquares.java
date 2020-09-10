package leetCode.treeStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class H_425_wordSquares {

    /**
     * Time O()
     * Space O()
     * Backtracking
     */
    public List<List<String>> wordSquares1(String[] words) {
        HashMap<String, HashSet<String>> prefix = new HashMap<>();
        for(String word: words){
            for(int i = 1; i <= word.length(); i++){
                String s = word.substring(0, i);
                prefix.putIfAbsent(s, new HashSet<>());
                prefix.get(s).add(word);
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> candidate;
        for(String word: words){
            candidate = new ArrayList<>();
            candidate.add(word);
            dfs(res, candidate, 1, words[0].length(), prefix);
        }
        return res;
    }

    private void dfs(List<List<String>> res, List<String> candidate, int pos, int len, HashMap<String, HashSet<String>> prefix){
        if(pos == len){
            res.add(new ArrayList<>(candidate));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(String cand : candidate){
            sb.append(cand.charAt(pos));
        }
        if(!prefix.containsKey(sb.toString())){
            return;
        }
        for(String next : prefix.get(sb.toString())){
            candidate.add(next);
            dfs(res, candidate, pos + 1, len, prefix);
            candidate.remove(candidate.size() - 1);
        }
    }


    /**
     * Time O(n!) & O(N * L) N: words : L : max(len)
     * Space O(nL) 不确定
     * TrieTree的方法
     */
    TrieNode root;
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        root = new TrieNode();
        buildTrie(words);
        findSquare(res, new ArrayList<>(), words[0].length());
        return res;
    }

    private void findSquare(List<List<String>> res, List<String> candidate, int len) {
        if (candidate.size() == len) {
            res.add(new ArrayList<>(candidate));
            return;
        }
        int index = candidate.size();
        StringBuilder sb = new StringBuilder();
        for (String s : candidate) {
            sb.append(s.charAt(index));
        }
        String s = sb.toString();
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            if (node.next[s.charAt(i) - 'a'] != null) {
                node = node.next[s.charAt(i) - 'a'];
            } else {
                node = null;
                break;
            }
        }
        if (node != null) {
            for (String next : node.words) {
                candidate.add(next);
                findSquare(res, candidate, len);
                candidate.remove(candidate.size() - 1);
            }
        }
    }

    private void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            char[] array = word.toCharArray();
            for (char c : array) {
                node.words.add(word);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.words.add(word);
        }
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        List<String> words = new ArrayList<>();
    }
}
