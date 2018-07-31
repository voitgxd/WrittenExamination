package nowcoder.swordToOffer;

public class _13_RobotMove {
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int result = 0;

    public static boolean canMove(int r, int c, int threshold) {
        String row = String.valueOf(r);
        String col = String.valueOf(c);
        int count = 0;
        for (int i = 0; i < row.length(); i++) {
            count += Integer.parseInt(row.charAt(i) + "");
        }
        for (int i = 0; i < col.length(); i++) {
            count += Integer.parseInt(col.charAt(i) + "");
        }
        return count > threshold ? false : true;
    }

    public static void move(int[][] matrix, int r, int c, int threshold) {
        if (r < 0 || r > matrix.length - 1 || c < 0 || c > matrix[0].length - 1 || matrix[r][c] == 1 || !canMove(r, c, threshold)) {
            return;
        }
        matrix[r][c] = 1;
        result++;
        for (int[] dir : direction) {
            move(matrix, r + dir[0], c + dir[1], threshold);

        }
    }

    public static int movingCount(int threshold, int rows, int cols) {
        int matrix[][] = new int[rows][cols];
        move(matrix, 0, 0, threshold);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(15, 20, 20));
    }
}
