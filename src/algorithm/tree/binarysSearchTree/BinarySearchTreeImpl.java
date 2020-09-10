package algorithm.tree.binarysSearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeImpl implements iBinarySearchTree{


    private TreeNode root;

    private int size;

    public BinarySearchTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {

        root = add(root,val);

    }
    private TreeNode add(TreeNode node, int val) {
        if(node == null) {
            size++;
            return new TreeNode(val);
        }
        if (node.val == val) {
            throw new IllegalArgumentException("节点已存在");
        }
        if(node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        return node;
    }

    /**
     * 如果删除根节点，可以左子树的最大值或者右子树的最小值替代。
     * @param val
     */
    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    private TreeNode remove(TreeNode node, int val) {
        if(node == null) {
            return null;
        }
        if(node.val > val) {
            node.left = remove(node.left, val);
        } else if(node.val < val) {
            node.right = remove(node.right, val);
        } else {
            if(node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null){
                size--;
                return node.left;
            }
            TreeNode minNode = findMin(node.right);
            node.val = minNode.val;
            node.right = remove(node.right, node.val);
        }
        return node;
    }

    //找到最小值
    private TreeNode findMin(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }


    /**
     * Time: o(longn)也就是O(h),即每一层都走了一次，如果是一条链，还是O(N)
     * @param val
     * @return
     */
    //用先序遍历
    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(TreeNode node, int val) {
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void print() {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("第" + (level + 1) + "层");
            List<Integer> list =new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
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

        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.add(8);
        binarySearchTree.add(5);
        binarySearchTree.add(6);
        binarySearchTree.add(3);
        binarySearchTree.add(10);
        binarySearchTree.add(9);
        binarySearchTree.add(11);
//        binarySearchTree.print();
        binarySearchTree.remove(8);
        binarySearchTree.print();
//        System.out.println(binarySearchTree.contains(0));
    }
}
