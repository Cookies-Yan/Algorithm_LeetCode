package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// Time O(h)
// SpaceO(1)
public class E_270_ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }

    /*Time O(n)*/
    public int closestValue1(TreeNode root, double target) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        double temp = Long.MAX_VALUE;
        int result = root.val;

        while(cur!= null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;

            }
            cur = stack.pop();
            if(Math.abs(cur.val - target) < temp){
                result = cur.val;
                temp = Math.abs(cur.val - target);
            }
            cur = cur.right;


        }
        return result;
    }
}
