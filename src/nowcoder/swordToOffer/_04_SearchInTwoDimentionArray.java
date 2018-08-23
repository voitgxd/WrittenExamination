package nowcoder.swordToOffer;

public class _04_SearchInTwoDimentionArray {

    // 最坏情况下 O(M * N)
    public static boolean find(int target, int[][] array) {
        int dim_0 = array.length;
        if (array == null || dim_0 == 0 || array[0].length == 0) {
            return false;
        }
        int dim_1 = array[0].length;
        int x = 0, y = dim_1 - 1;
        while (x < dim_0 && y >= 0) {
            if (array[x][y] == target)
                return true;
            if (x < dim_0 && y >= 0 && array[x][y] < target)
                x++;
            if (x < dim_0 && y >= 0 && array[x][y] > target)
                y--;
        }
        return false;
    }

    // O(M + N) + O(1)
    public static boolean find_2(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = array.length, col = array[0].length;
        int r = 0, c = col - 1;
        while (r <= row - 1 && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {4, 7, 10, 13}};
        System.out.println(find(2, matrix));
        System.out.println(find_2(2, matrix));
    }
}
