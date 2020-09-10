package leetCode.tree_13;
import algorithm.tree.binarysSearchTree.TreeNode;
import java.util.Stack;

//Time O(1)
//Space O(h)
public class M_173_BinarySearchTreeIterator {

    private TreeNode cur;
    private Stack<TreeNode> stack;

    public void BSTIterator(TreeNode root) { //源码中把void去掉
        cur = root;
        stack = new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (cur != null || !stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
