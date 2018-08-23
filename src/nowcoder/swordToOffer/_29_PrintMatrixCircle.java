package nowcoder.swordToOffer;

import java.util.ArrayList;

public class _29_PrintMatrixCircle {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int lx = 0, ly = 0, rx = matrix.length - 1, ry = matrix[0].length - 1;
        while (lx <= rx && ly <= ry) {
            int x = lx, y = ly;
            boolean flag = ry - ly == 0 || rx - lx == 0;
            while (y <= ry) {
                result.add(matrix[lx][y++]);
            }
            x = lx + 1;
            while (x <= rx) {
                result.add(matrix[x++][ry]);
            }
            y = ry - 1;
            while (!flag && y >= ly) {
                result.add(matrix[rx][y--]);
            }
            x = rx - 1;
            while (!flag && x > lx) {
                result.add(matrix[x--][ly]);
            }
            lx++;
            ly++;
            rx--;
            ry--;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        //1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13
//        int[][] matrix = {{1}};
//        int[][] matrix = {{1}, {2}, {3}, {4}};
        int[][] matrix = {{1, 2, 3, 4}};
//        int[][] matrix = {{1, 2}, {3, 4}};

        String rightResult = "[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]";
        String result = printMatrix(matrix).toString();
        System.out.println(rightResult);
        System.out.println(result);
        System.out.println(result.equals(rightResult));
    }
}
