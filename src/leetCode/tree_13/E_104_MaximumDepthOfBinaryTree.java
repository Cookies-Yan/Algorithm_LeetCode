package leetCode.tree_13;

/**
 * Time: O(n);
 * Space:O(n);
 */

public class E_104_MaximumDepthOfBinaryTree {

    //后序遍历
    //Time O(n)
    //Space O(h)
    public static int maxDepth(TreeNode root) {

       if (root == null) return 0;
       int l = maxDepth(root.left) + 1;
       int r = maxDepth(root.right) + 1;
       return Math.max(l, r);

   }

    int res;
    public int maxDepth1(TreeNode root) {
        res = 0;
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        return Math.max(left, right);
    }

    /*简便写法*/
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);

        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;

        E_104_MaximumDepthOfBinaryTree hasPath = new E_104_MaximumDepthOfBinaryTree();
        System.out.println(hasPath.maxDepth(root));
    }

    private static class TreeNode {

        TreeNode left;

        TreeNode right;

        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
