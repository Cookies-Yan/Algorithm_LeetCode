package leetCode.tree_13;

import java.util.LinkedList;
import java.util.Queue;

public class E_101_SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*递归*/
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) {
            return false;
        }
        return helper(p.left, q.right) && helper(p.right, q.left);
    }

    /*迭代*/
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        if(root == null) return true;
        if(root.left != null && root.right != null){
            left.add(root.left);
            right.add(root.right);
        }else if (root.left != null || root.right != null){
            return false;
        }


        while(!left.isEmpty()&&!right.isEmpty()){
            TreeNode l = left.poll();
            TreeNode r = right.poll();

            if( l.val != r.val){
                return false;
            }


            if(l.left != null && r.right != null){
                left.add(l.left);
                right.add(r.right);
            }else if (l.left != null || r.right != null){
                return false;
            }
            if(l.right != null && r.left != null){
                left.add(l.right);
                right.add(r.left);
            }else if (l.right != null || r.left != null){
                return false;
            }


        }
        return true;


    }
}
