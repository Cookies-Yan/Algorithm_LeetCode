package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Inorder
 */
public class E_501_FindModeInBinarySearchTree {
    /**
     * [4,4,12,3,5,12,null,null,null,5,null,null,null] 无法通过
     * 因为这不是一个BST 
     */
    //不用hashmap
    //Time O(n)
    //Space O(h)
    int count = 1;
    int max = 0;
    Integer pre = null;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        if (pre != null) {
            if (root.val == pre) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max){
            list.add(root.val);
        }
        pre = root.val;
        helper(root.right, list);
    }

    /**
     * HashMap
     * [4,4,12,3,5,12,null,null,null,5,null,null,null] 可通过
     */
    //Time O(n)
    //Space O(h)
    int max1;
    HashMap<Integer, Integer> map;
    public int[] findMode1(TreeNode root) {
        if (root == null) return new int[0];
        map = new HashMap<>();
        max1 = 0;
        helper(root);

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max1) {
                list.add(key);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        int count = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, count);
        max1 = Math.max(max1, count);
        helper(root.right);
    }
}
