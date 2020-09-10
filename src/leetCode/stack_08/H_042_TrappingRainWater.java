package leetCode.stack_08;

import java.util.Stack;

/**
 * Time: O(n)
 * Space: O(1)
 * Created by Cookies
 * 采用双指针
 *
 */

public class H_042_TrappingRainWater {
    public static int trap(int height[]){
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            } else{
                rightMax = Math.max(height[right],rightMax);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    /**
     * stack迭代极值
     * stack中不能存柱子的高度，存的是index
     * @param
     */

    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int idx = 0;
        while (idx < height.length) {
            while (!stack.isEmpty() && height[idx] > height[stack.peek()]) {
                int highIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int dis = idx - stack.peek() - 1;
                int high = Math.min(height[idx], height[stack.peek()]) - height[highIndex];
                res += dis * high;
            }
            stack.push(idx++);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
        System.out.println(res);
    }
}
