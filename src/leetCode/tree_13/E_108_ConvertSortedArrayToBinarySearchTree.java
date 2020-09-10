package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

public class E_108_ConvertSortedArrayToBinarySearchTree {
    // Time O(n)
    // Space O(logn)
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
