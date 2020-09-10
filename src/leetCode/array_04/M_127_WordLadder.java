package leetCode.array_04;


import java.util.*;

/**
 * 这个写法比较复杂
 */
public class M_127_WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Graph graph = new Graph();
        for (String word : wordList) {
            graph.addNode(new Node(word));
        }
        /**
         * 有时候beginWord不在wordList里面，需要提前加入，方便后面遍历
         */
        if (!wordList.contains(beginWord)) {
            graph.addNode(new Node(beginWord));
            wordList.add(beginWord);
        }

        for (String word : wordList) {
            Node node = graph.getNode(word);
            /**
             * 进行变换
             */
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) { //从a到z一步一步进行计算
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    /**
                     * 这个没有这个单词或者元你来没有加过，并且不重复
                     */
                    if (graph.getNode(temp) != null && !node.neighbors.contains(temp) && !temp.equals(word)) {
                        node.neighbors.add(graph.getNode(temp));
                    }
                }
            }
        }

        HashSet<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        visited.add(graph.getNode(beginWord));
        queue.offer(graph.getNode(beginWord));

        int res = 0;

        while (!queue.isEmpty()) {
            //用size来控制层数，
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.word.equals(endWord)) {
                    return res;
                }
                for (Node neighbor : node.neighbors) {
                    if(!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 把每个node相连
     */
    static class Graph {

        List<Node> nodes;
        HashMap<String, Integer> map; //遍历找节点很麻烦，直接用HashMap来找很方便

        public Graph() {
            this.nodes = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public void addNode(Node node) {
            /**
             * key:单词 value:是index，即为该单词在list里面的位置
             */
            map.put(node.word, nodes.size());
            nodes.add(node);
        }

        /**
         * 通过map找位置，通过位置找在list里面拿node
         * @param word
         * @return
         */
        public Node getNode(String word) {
            if (map.containsKey(word)) {
                return nodes.get(map.get(word));
            }
            return null;
        }
    }

    /**
     * 把wordlist都转成node,并且连起来
     */
    static class Node {

        String word;
        List<Node> neighbors;

        public Node(String word) {
            this.word = word;
            this.neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        String a = "hit";
        String b = "cog";
        String[] c = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> list = new ArrayList<>(Arrays.asList(c));
        System.out.println(ladderLength(a, b, list));
    }
}
