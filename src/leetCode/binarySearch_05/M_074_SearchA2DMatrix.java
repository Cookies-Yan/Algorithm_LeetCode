package leetCode.binarySearch_05;

public class M_074_SearchA2DMatrix {

    /**
     * Time O(log(n*m))
     * Space O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = matrix[mid / col][mid % col]; //把4,转化成坐标[1，1]，即为一维index转2维
            if (value == target) {
                return true;
            } else if (value > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    /**
     * 另一种写法
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int x = mid / col;
            int y = mid % col;
            if (matrix[x][y]  == target) {
                return true;
            } else if (matrix[x][y] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (matrix[left / col][left % col] == target) return true;
        if (matrix[right / col][right % col] == target) return true;
        return false;
    }
}
