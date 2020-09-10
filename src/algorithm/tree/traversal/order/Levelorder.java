package algorithm.tree.traversal.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Levelorder {

    //迭代实现
    public void levelorder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list =new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                list.add(cur.val);
            }
            res.add(list);
        }
        print(res);
    }

    //递归实现

    /**
     * 本方法先将大的List里面的小list的level建立，然后逐渐递归至上
     * {{3}
     *  {9,8}
     *  {4,5,1,7}
     *  {2,10}}
     * @param root
     */
    public void levelorder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return;
        }
        helper(res, root ,0);
        print(res);
    }
    private void helper(List<List<Integer>> lists, TreeNode root, int level) {

        if(root == null) {
            return;
        }
        if (level >= lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        helper(lists, root.left, level + 1);
        helper(lists, root.right, level + 1);
    }

    private void print (List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
                
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);


        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;

        Levelorder levelorder = new Levelorder();
        levelorder.levelorder2(root);

    }
}
