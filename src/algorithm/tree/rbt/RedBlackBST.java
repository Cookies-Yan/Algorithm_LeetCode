package algorithm.tree.rbt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在JAVA源码中的遍历功能非常常见 O（h）,例如：HashMap
 */

//键值对进行一个比较，扩展Comparable. 做成HashMap这种形式。用红黑树来存一个键值对这样的形式
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    //不是红就是黑
    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private Node root;

    // 定义一个内部的类
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value =value;
            this.color = color;
            this.size = size;
        }
    }

    public RedBlackBST() {

    }

    //判断是红还是黑
    private boolean isRed(Node node) {
        if(node == null) {
            return false;
        }
        return node.color == RED;
    }


    private int size(Node node) {
        if(node == null) {
            return 0;
        }
        return node.size;
    }

    public int size () {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    //与BST和AVL的contains没有什么区别
    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("为空");
        }
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        while (root != null) {
            //key 与 node.key进行比较
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    /**
     * 左旋转
     * 小写为空节点（BLACK）,也可能为子树
     *        H (BLACK)              X(BLACK)
     *       / \                    / \
     *      a   X (RED)  ====>(RED)H   c
     *         / \                / \
     *        b  C               a   b
     * @param h
     * @return
     */
    private Node rotateLeft (Node h) {
        //旋转
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        //颜色改变
        x.color = x.left.color; //X并不一定是黑色，因为还要走上一层进行再次变幻
        x.left.color = RED;
        x.size = h.size; //X和H调换位置了，所以要互换
        h.size = size(h.left) + size(h.right) + 1; //H接受了X的子树(b)，所以要重新计算一下，再加上自己本身
        return x;

    }

    /**
     * 右旋转
     *          H(BLACK)               X(BLACK)
     *         / \                    / \
     *   (RED)X   b     =====>  (RED)Y  H(RED)
     *       / \                       / \
     * (RED)Y  a                      a   b
     * @param h
     * @return
     */
    private Node rotateRight (Node h) {
        //旋转
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        //颜色改变
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1; //H接受了X的子树(b)，所以要重新计算一下，再加上自己本身
        return x;
    }
    /**
     * 颜色翻转
     *
     *         X(BLACK)  X与上面的父亲融合           X(RED)
     *        / \        ============>           / \
     *  (RED)Y  H(RED)                   (BLACK)Y  H(BLACK)
     *
     */
    private void flipColors(Node h) {
        //前面写了color非黑即红
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    /**
     * 插入
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("为空");
        }

        root = put(root, key, value);
        //加入任何一个节点都是红色的，需要把根节点变成黑色的
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node (key, value, RED, 1);
        }
        //决定往左边还是右边走
        int cmp = key.compareTo(node.key);
        if (cmp < 0)       node.left = put(node.left, key, value);
        else if (cmp > 0)  node.right = put(node.left, key, value);
        else               node.value = value; //如果已存在，就把值进行替换
        //进行翻转
        /**
         * 左旋转只能是这个种情况：(即为A红B黑，因为当AB都为红时，我们只进行颜色翻转)
         *           H                     H
         *         /  \                  /  \ (不用转)
         * (BLACK)A   B(RED)       (RED)A    B(RED)
         */
        if (isRed(node.right) && !isRed(node.left))    node = rotateLeft(node);
        /**
         *  右旋转（右边全红）
         *             H(BLACK)               H(BLACK)
         *            / \                    /
         *      (RED)X   b     =====>       X(RED)
         *          / \                    /
         *    (RED)Y  a                   Y(BLACK)
         */
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        /**
         *   颜色翻转
         *            X(BLACK)              X(RED)
         *           / \                   / \
         *     (RED)Y  H(RED)      (BLACK)Y  H(BLACK)
         *
         */
         if(isRed(node.left) && isRed(node.right))     flipColors(node);
         //更新size
         node.size = size(node.left) + size(node.right) + 1;

         return node;
    }

    private void check() {
        if(!isBST())      System.out.println("不是BST");
        if(!isSize())     System.out.println("Size 不对");
        if(!is23())       System.out.println("不是 2-3 树");
        if(!isBalanced()) System.out.println("不是黑平衡"); //红黑树并不是一个平衡树，不能直接用AVL树的，是一个黑平衡，判断是不是一个黑平衡
        System.out.println("是红黑树");
    }

    private boolean isBST() {
        return isBST(root, null, null);
    }
    //在不知道左边右边值的情况下，先赋值null
    private boolean isBST(Node node, Key min, Key max) {
        if(node == null) return true;
        if(min != null && node.key.compareTo(min) <= 0) return false;
        if(max != null && node.key.compareTo(max) >= 0) return false;
        return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
    }

    private boolean isSize() {
        return isSize(root);
    }

    private boolean isSize(Node node) {
        if (node == null) return true;
        if (node.size != size(node.left) + size(node.right) + 1) {
            return false;
        }
        return isSize(node.left) && isSize(node.right);
    }

    //3节点的23树红的节点左倾斜，最右边肯定不能是红色
    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node node) {
        if (node == null) return true;
        if (isRed(node.right)) return false;
        if (node != root && isRed(node) && isRed(node.left)) { //两个左子树不能出现两个红色
            return false;
        }
        return is23(node.left) && is23(node.right);
    }

    private boolean isBalanced() {
        int black = 0;
        Node node = root;
        while (node != null) {
            if (!isRed(node)) {
                black++;
            }
            node = node.left;
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node node, int black) {
        if (node == null) {
            return black == 0;
        }
        if (!isRed(node)) black--;
        return isBalanced(node.left, black) && isBalanced(node.right, black);
    }


    private void print() {
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        System.out.println("根节点的颜色 : " + root.color);
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("第" + (level + 1) + "层");
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                System.out.print(cur.key);
                if (cur.left != null) {
                    System.out.println(" 左孩子： " + cur.left.key + " 的颜色" + cur.left.color);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    System.out.println(" 右孩子： " + cur.right.key + " 的颜色" + cur.right.color);
                    queue.offer(cur.right);
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<>();
        redBlackBST.put(12, 1);
        redBlackBST.put(1, 1);
        redBlackBST.put(9, 1);
        redBlackBST.put(2, 1);
        redBlackBST.put(0, 1);
        redBlackBST.put(11, 1);
        redBlackBST.put(7, 1);
        redBlackBST.put(19, 1);
        redBlackBST.put(4, 1);
        redBlackBST.put(15, 1);
        redBlackBST.put(18, 1);
        redBlackBST.put(5, 1);
        redBlackBST.put(14, 1);
        redBlackBST.put(13, 1);
        redBlackBST.put(10, 1);
        redBlackBST.put(16, 1);
        redBlackBST.put(6, 1);
        redBlackBST.put(3, 1);
        redBlackBST.put(8, 1);
        redBlackBST.put(17, 1);
        redBlackBST.check();
        redBlackBST.print();
    }

}
