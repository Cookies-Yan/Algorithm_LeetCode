package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class H_272_ClosestBinarySearchTreeValueII {
    //Time O(n)
    //Space O(n)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode root, double target, int k) {
        if (root == null) return;
        helper(res, root.left, target, k);
        if (res.size() == k) {
            // res 的add 是 1->2->3在后面加入， PeekFirst顺序是 1->2->3, removeFirst顺序也如此
            if (Math.abs(target - root.val) < Math.abs(target - res.peekFirst())) {
                res.removeFirst();
            } else return;
        }
        res.add(root.val);
        helper(res, root.right, target, k);
    }

    /**
     * Time O(klogn)
     * Space O(h)
     * Stack : pred
     * Stack : succ
     * res :
     */
    public List<Integer> closestKValues1(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        iniPred(root, target, pred);
        iniSucc(root, target, succ);
        if (!pred.isEmpty() && !succ.isEmpty() && succ.peek().val == pred.peek().val) {
            //如果前驱后继都有的话，会重复加入，所以要删除一个
            helper(pred, false);
        }
        while (k-- > 0) {
            if (succ.isEmpty()) {
                res.add(helper(pred, false));
            } else if (pred.isEmpty()) {
                res.add(helper(succ, true));
            } else {
                double succDiff = Math.abs((double) succ.peek().val - target);
                double predDiff = Math.abs((double) pred.peek().val - target);
                if (succDiff < predDiff) {
                    res.add(helper(succ, true));
                } else {
                    res.add(helper(pred, false));
                }
            }
        }
        return res;
    }

    //找后继节点
    private void iniSucc(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                break;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    //找前驱节点
    private void iniPred(TreeNode root, double target, Stack<TreeNode> pred) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                break;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private int helper(Stack<TreeNode> stack, boolean isSucc) {
        TreeNode cur = stack.pop();
        int res = cur.val;

        if (isSucc) cur = cur.right;
        else cur = cur.left;

        while (cur != null) {
            stack.push(cur);
            if (isSucc) cur = cur.left;
            else cur = cur.right;
        }
        return res;
    }
}
