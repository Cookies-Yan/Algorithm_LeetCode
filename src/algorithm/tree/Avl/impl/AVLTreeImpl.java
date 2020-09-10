package algorithm.tree.Avl.impl;

import algorithm.tree.Avl.AVLNode;
import algorithm.tree.Avl.IAVLTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTreeImpl implements IAVLTree {

    AVLNode root;

    int size;

    public AVLTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        root = add(root, val);
    }

    private AVLNode add(AVLNode node, int val) {
        if(node == null) {
            size ++;
            return new AVLNode(val);
        }
        if (node.val == val) {
            throw new IllegalArgumentException("节点已经存在");
        }
        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }

        //其高度等于根节点，然后加上左子树和右子树最大的高度
        //每加一个点，就将其高度存储在其height的属性内
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        //需要在跟新高度的时候就开始计算平衡因子来判定是否要调整
        int balanceFactor = getBalanceFactor(node);

        /**
         *          x   balanceFactor > 1 判断是否在x左边 && 本节点需不需要旋转
         *         /
         *        y    getBalanceFactor(node.left) >= 0)  判断y的左边
         *       /
         *      z      保证需要旋转的枝干不是zig-zag
         */
        //节点都在左边一条线
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        /**
         *        x    balanceFactor < -1 判断是否在x右边 && 本节点需不需要旋转
         *         \
         *         y    getBalanceFactor(node.left) < 0)  判断y的右边
         *         \
         *         z    保证需要旋转的枝干不是zig-zag
         */
        //节点都在右边一条线上
        if(balanceFactor < -1 && getBalanceFactor(node.left) <= 0) {
            return leftRotate(node);
        }
        /**
         *      x    balanceFactor > 1 判断是否在x左边 && 本节点需不需要旋转
         *     /
         *    y      getBalanceFactor(node.left) < 0 判断y的右边
         *     \
         *      z
         *
         *      x                 x                z
         *    /  \              /  \             /  \
         *   y   D     LL      z   D    RR      y    x
         *  / \       ====>   / \      ====>   / \  / \
         * C  z              y  B             C  A B  D
         *   / \            / \
         *  A  B           C  A
         *
         */
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        /**
         *      x      balanceFactor < -1 判断是否在x右边 && 本节点需不需要旋转
         *       \
         *       y     getBalanceFactor(node.right) > 0 判断y的左边
         *      /
         *     z
         *
         *      x                 x                    z
         *    /  \              /  \                 /  \
         *   D   y     RR      D   z      LL        x    y
         *      / \   ====>       / \    ====>     / \  / \
         *    z   C              A   y            D  A B  C
         *   / \                    / \
         *  A  B                   B  C
         *
         */
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     *           x                 y
     *         /  \              /  \
     *        y   D    RR       z   x
     *      /  \      ===>    /  \ /  \
     *     z   C             A   B C  D
     *   /  \
     *  A   B
     *
     * @param x
     * @return
     */
    //右旋
    private AVLNode rightRotate(AVLNode x) {
        AVLNode y = x.left;
        AVLNode C = y.right;

        y.right = x;
        x.left = C;

        //重新计算高度
        //x和y不可调换，因为y的高度依赖于x
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;

    }

    /**
     *         x                    y
     *       /   \                /  \
     *      D    y       LL      z    x
     *         /  \     ===>   /  \ /  \
     *        C   Z           A   B C  D
     *          /  \
     *         A   B
     *
     * @param x
     * @return
     */
    //左旋
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode C = y.left;

        y.left = x;
        x.right = C;

        //重新计算高度
        //x和y不可调换，因为y的高度依赖于x
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    @Override
    public void remove(int val) {
        //AVL是一个BST，可以参考BST的删除
        root = remove(root, val);
    }

    private AVLNode remove(AVLNode node, int val) {
        if(node == null) {
            return null;
        }

        AVLNode changeNode;
        /**
         * 我们在renmove之后的节点位置会发生变化，所以我们需要给一个新的节点，然后统一发生变化
         */
        if(node.val > val) {
            node.left = remove(node.left, val);
            changeNode = node;
        } else if(node.val < val) {
            node.right = remove(node.right, val);
            changeNode = node;
        } else {
            if(node.left == null) {
                size--;
                changeNode = node.right;
            } else if (node.right == null){
                size--;
                changeNode = node.left;
            } else {
                AVLNode minNode = findMin(node.right);
                node.val = minNode.val;
                node.right = remove(node.right, node.val);
                changeNode = node;
            }
        }

        if(changeNode ==  null) return null;

        changeNode.height = 1 + Math.max(getHeight(changeNode.left), getHeight(changeNode.right));
        //需要在跟新高度的时候就开始计算平衡因子来判定是否要调整
        int balanceFactor = getBalanceFactor(changeNode);

        //节点都在左边一条线
        if(balanceFactor > 1 && getBalanceFactor(changeNode.left) >= 0) {
            return rightRotate(changeNode);
        }

        //节点都在右边一条线上
        if(balanceFactor < -1 && getBalanceFactor(changeNode.left) <= 0) {
            return leftRotate(changeNode);
        }

        if(balanceFactor > 1 && getBalanceFactor(changeNode.left) < 0) {
            changeNode.left = leftRotate(changeNode.left);
            return rightRotate(changeNode);
        }

        if(balanceFactor < -1 && getBalanceFactor(changeNode.right) > 0) {
            changeNode.right = rightRotate(changeNode.right);
            return leftRotate(changeNode);
        }

        return changeNode;
    }

    //找到最小值
    private AVLNode findMin(AVLNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    //跟二叉搜索树没有任何区别
    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(AVLNode node, int val) {
        if(node == null) {
            return false;
        }
        if(node.val == val) {
            return true;
        } else if (node.val > val){
            return contains(node.left, val);
        } else {
            return contains(node.right, val);
        }
    }

    private int getBalanceFactor(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // LC 104题也是要求一个二叉树的最大高度
    // 如果不是null就返回其节点所在的高度
    private int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    //LC 98题
    //AVLTree的前提首先是二叉搜索树
    private boolean isBST(AVLNode node) {
        if(node == null) {
            return true;
        }
        return helper(node, null, null);
    }
    //在不知道左边右边值的情况下，先赋值null
    private static boolean helper(AVLNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    //LC 110题
    private boolean isBalanced(AVLNode node) {
        if(node == null) {
            return true;
        }
        return helper(node) != -1;
    }

    private int helper(AVLNode root) {
        if(root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if(l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }

    /**
     * 我们还可以有另外一种判断是不是平衡树的标准
     * @param
     */
    private boolean isBalanced2(AVLNode node) {
        if(node == null) return true;
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced2(node.left) && isBalanced2(node.right);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private void print() {
        int level = 0;
        Queue<AVLNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("第" + (level + 1) + "层");
            List<Integer> list =new ArrayList<>();
            for(int i = 0; i < size; i++) {
                AVLNode cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left != null) {
                    System.out.println(" 左孩子： " + cur.left.val);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    System.out.println(" 右孩子： " + cur.right.val);
                    queue.offer(cur.right);
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {

        AVLTreeImpl avlTree = new AVLTreeImpl();
        avlTree.add(8);
        avlTree.add(5);
        avlTree.add(6);
        avlTree.print(); //验证旋转
        avlTree.add(3);
        avlTree.add(10);
        avlTree.add(9);
        avlTree.add(11);
        avlTree.add(2);
        avlTree.add(1);
        avlTree.remove(5);
        avlTree.print();
        System.out.println("是否是BST： " + avlTree.isBST(avlTree.root));
        System.out.println("是否是Balanced： " + avlTree.isBalanced2(avlTree.root));
        System.out.println("Size : " + avlTree.size());
        System.out.println("Contain :" + avlTree.contains(100));

    }
}
