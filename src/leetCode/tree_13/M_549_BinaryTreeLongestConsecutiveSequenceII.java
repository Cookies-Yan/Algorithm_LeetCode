package leetCode.tree_13;
import algorithm.tree.binarysSearchTree.TreeNode;
//Time O(n)
//Space O(h)
public class M_549_BinaryTreeLongestConsecutiveSequenceII {
    /*后序遍历*/
    int res;
    public int longestConsecutive(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    public int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int dcr = 1;
        int icr = 1;

        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                icr = left[1] + 1;
            }
            if (root.left.val == root.val - 1) {
                dcr = left[0] + 1;
            }
        }
        //{0,0}第一个0为从子节点到root递增的情况，第二个0位递减的情况
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                //因为很有可能左右节点不为空，上面的dcr和icr已经做了更新， 很有可能right[1] + 1 < icr(值又给更新小了)
                icr = Math.max(icr, right[1] + 1);
            }
            if (root.right.val == root.val - 1) {
                dcr = Math.max(dcr, right[0] + 1);
            }
        }
        res = Math.max(res, dcr + icr - 1);
        return new int[]{dcr, icr};

    }
}
