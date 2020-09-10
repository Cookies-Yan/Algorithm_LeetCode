package leetCode.tree_13;

import java.util.LinkedList;

public class E_100_SameTree {

    //Time O(n)
    //Space O(h)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*递归*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*迭代*/
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pp = new LinkedList<TreeNode>();
        LinkedList<TreeNode> qq = new LinkedList<TreeNode>();
        pp.add(p);
        qq.add(q);

        while(!pp.isEmpty() && !qq.isEmpty()){
            TreeNode curr_p = pp.pollLast();
            TreeNode curr_q = qq.pollLast();
            if(curr_p == null && curr_q == null){
                return true;
            }
            if(curr_p == null || curr_q == null ||curr_p.val != curr_q.val){
                return false;
            }
            if(curr_p.left != null && curr_q.left != null) {
                pp.add(curr_p.left);
                qq.add(curr_q.left);
            }else if(curr_p.left != null || curr_q.left != null ){
                return false;
            }
            if(curr_p.right != null && curr_q.right != null) {
                pp.add(curr_p.right);
                qq.add(curr_q.right);
            }else if(curr_p.right != null || curr_q.right != null){
                return false;
            }

        }
        return true;
    }
}
