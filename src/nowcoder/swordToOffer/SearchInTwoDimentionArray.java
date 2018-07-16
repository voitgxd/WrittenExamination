package nowcoder.swordToOffer;

public class SearchInTwoDimentionArray {

    // 最坏情况下 O(M * N)
    public static boolean find(int target, int[][] array) {
        int dim_0 = array.length;
        if (array == null || dim_0 == 0 || array[0].length == 0) {
            return false;
        }
        int dim_1 = array[0].length;
        int row_index = -1;
        for (int i = 0; i < dim_0; i++) {
            if (target <= array[i][dim_1 - 1]) {
                row_index = i;
                break;
            }
        }
        if (row_index == -1) {
            return false;
        }
        while (row_index < dim_0) {
            for (int j = 0; j < dim_1; j++) {
                if (target == array[row_index][j]) {
                    return true;
                }
            }
            row_index++;
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
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(2, matrix));
        System.out.println(find_2(2, matrix));
    }
}
