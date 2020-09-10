package leetCode.tree_13;

public class E_112_PathSum {


    /**
     * 从头走到尾 不需要树的遍历
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum){

        if(root == null)return false;
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(1);


        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.right = t8;

        System.out.println(hasPathSum(root, 22));
        System.out.println(hasPathSum(root, 23));
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
