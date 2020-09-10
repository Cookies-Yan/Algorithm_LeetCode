package leetCode.binarySearch_05;

public class H_302_SmallestRectangleEnclosingBlackPixels {
    /**
     * Time O(mlogn + nlogm)
     * Space O(1)
     *[[1, 0, 1, 0],
     * [0, 1, 1, 0],
     * [0, 1, 0, 1]]
     * x = 0 y = 2
     * output = 12
     * 仔细手动跑一下就知道为什么mid = left / right了
     * @param image
     * @param x
     * @param y
     * @return
     */
    public int minArea(char[][] image, int x, int y) {
        int row = image.length;
        int col = image[0].length;

        int left = binarySearchLeft(image, 0, y, true);
        int right = binarySearchRight(image, y, col - 1, true);

        int top = binarySearchLeft(image, 0, x, false); //不是水平的了，改为false就可以
        int bottom = binarySearchRight(image, x, row - 1, false);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int binarySearchLeft(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (hasBlack(image, left, isHor)) {
            return left;
        }
        return right;
    }

    private int binarySearchRight(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (hasBlack(image, right, isHor)) {
            return right;
        }
        return left;
    }

    private boolean hasBlack(char[][] image, int x, boolean isHor) {
        if (isHor) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][x] == '1') return true;
            }
        } else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[x][i] == '1') return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] a = {{'1', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '1'}};
        H_302_SmallestRectangleEnclosingBlackPixels b = new H_302_SmallestRectangleEnclosingBlackPixels();
        System.out.println(b.minArea(a,0, 2));
    }
}