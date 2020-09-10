package leetCode.tree_13;

public class E_235_LowestCommonAncestorofBinarySearchTree {

    /**
     * 舍弃一边进行遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    //Time O(n)
    //Space O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
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
