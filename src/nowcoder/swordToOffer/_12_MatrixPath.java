package nowcoder.swordToOffer;

public class _12_MatrixPath {
    // up down left right
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static char[][] generateMatrix(char[] matrix, int rows, int cols) {
        char[][] resultMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix[i * cols + j];
            }
        }
        return resultMatrix;
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] charMatrix = generateMatrix(matrix, rows, cols);
        boolean[][] isCovered = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(charMatrix, str, isCovered, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    public static boolean backtracking(char[][] matrix, char[] str, boolean[][] isCovered, int pathLen, int r, int c) {
        System.out.println("coordinate:[" + r + ", " + c + "]");
        if (pathLen == str.length)
            return true;
        if (r < 0 || r > matrix.length - 1 || c < 0 || c > matrix[0].length - 1 || matrix[r][c] != str[pathLen] || isCovered[r][c])
            return false;
        //System.out.println("coordinate:[" + r + ", " + c + "]" + " and pathLen:" + pathLen + " currentChar: " + matrix[r][c] + " str[pathLen]:" + str[pathLen]);
        isCovered[r][c] = true;
        for (int[] dir : direction) {
            if (backtracking(matrix, str, isCovered, pathLen + 1, r + dir[0], c + dir[1]))
                return true;
        }
        isCovered[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
//        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        // ABCESFCSADEE
        char[] matrix = {'A', 'B', 'C', 'E', 'S', 'F', 'X', 'S', 'A', 'D', 'E', 'E'};
        // a b c e
        // s f c s
        // a d e e
        // destination path is: b c c e d
//        char[] desStr = {'A', 'B', 'C', 'B'};
        char[] desStr = {'A', 'B', 'C', 'X', 'E', 'D'};
//        char[] desStr = {'S', 'E', 'E'};
        System.out.println(hasPath(matrix, 3, 4, desStr));
    }
}