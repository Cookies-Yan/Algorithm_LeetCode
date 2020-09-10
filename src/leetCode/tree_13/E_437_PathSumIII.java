package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.HashMap;
import java.util.Stack;

public class E_437_PathSumIII {

    /*DFS递归*/
    //Time O(n^2) Space: O(n)
    public int pathSum1(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return res;
        if (sum == root.val) res++;
        res += helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
        return res;
    }

    /*迭代*/
    public int number = 0;
    public int pathSum2(TreeNode root, int sum) {
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            Sum(current, sum);
            if(current.left!=null) stack.add(current.left);
            if(current.right != null) stack.add(current.right);
        }
        return number;
    }
    public void Sum(TreeNode root, int sum){
        if(root == null) return;
        sum = sum - root.val;
        if(sum == 0){
            number ++;
        }
        if(root.left == null && root.right == null){
            return ;
        }
        Sum(root.left,sum);
        Sum(root.right,sum);
    }

    /**
     * DFS + Memorization : HashMap<Integer, Integer> <curSum, Num>
     * 10 + -3 + 11 = 18  -3 + 11 = 8
     * (10, 1) (7, 1) 18 - 8 = 10 (a, b, c) = x (d, e) = 8  x = curSum - 8
     *
     * 以root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8为例：
     *
     * map: {0:1,16:0,17:0,18:0,21:0,7:0,10:0,15:0} 实际map存储情况
     * // map :(0, 1) (10, 1/0) (15, 1/0) (18, 1/0/1/0/1/0) (21, 1/0) (16, 1/0) (17, 1/0) (7, 1/0)
     * // res : 10( 5( 3 (1 + 0) + 2 (0 + 1)) + -3 (0 + 1)) = 3
     * @param root
     * @param sum
     * @return
     */
    //Time O(n) Space: O(n)
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //如果是0的话至少有一条路径
        return helper(root, 0, sum, map);
    }

    public int helper(TreeNode root, int curSum, int sum, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        curSum += root.val;
        int res = map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        res += helper(root.left, curSum, sum, map) + helper(root.right, curSum, sum, map);
        //最巧妙的一步，就是把之前map用过的(10，1) 给消掉，编程(10, 0)
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }
}
