package leetCode.binarySearch_05;

/**
 * 没有办法用二分查找
 * 不知道到底是哪一行哪一列
 */
public class M_240_SearchA3DMatrixII {
    /**
     * Time O(m + n)
     * Space O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) { //顺序不能变
            return false;
        }
        //从右上角出发
        int row = 0;
        int col = matrix[0].length - 1;

        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
