package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.*;

// Time O(n)
// Space O(h)
public class E_107_BinaryTreeLevelOrderTraversalII {

    /*迭代*/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(0, list); //倒着插入
        }
        return res;
    }

    /*递归*/
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }
    public static void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null ) return;
        if (level >= res.size()) {
            res.add(0, new ArrayList<>()); //与 LC102不同
        }
        res.get(res.size() - level - 1).add(root.val); //与 LC102不同
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }

    /*递归*/
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper1(res, root, 0);
        /**
         * 正面输入反向输出（只在结果处理）
         */
        Collections.reverse(res);
        return res;
    }

    public static void helper1(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null ) return;
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
