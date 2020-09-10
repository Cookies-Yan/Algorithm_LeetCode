package leetCode.stack_08;

import java.util.Stack;

public class H_084_LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) { //最后一步的处理，所以有个等号

            int hi = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && hi < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack .isEmpty() ? - 1 : stack.peek(); // -1处理前面比后面高，并且前面没有柱子了
                int area = height * (i - start - 1);
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }

}
