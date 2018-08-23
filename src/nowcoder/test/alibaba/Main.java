package nowcoder.test.alibaba;

import java.util.Scanner;

public class Main {
    private static final Point startPoint = new Point(0, 0);
    private static int minPathLen = Integer.MAX_VALUE;

    public static int calculate(Point p, Point[] points, int sum, int count) {
        if (count == points.length) {
            minPathLen = Math.min(minPathLen, sum + calculatePathLen(p, startPoint));
            return minPathLen;
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i].visited == false) {
                sum += calculatePathLen(points[i], p);
                if (sum < minPathLen) {
                    points[i].visited = true;
                    calculate(points[i], points, sum, count + 1);
                }
                sum -= calculatePathLen(points[i], p);
                points[i].visited = false;
            }
        }
        return minPathLen;
    }

    private static int calculatePathLen(Point p1, Point p2) {
        if (p1 == null || p2 == null)
            return 0;
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pointNum = Integer.parseInt(input.nextLine().trim());
        Point[] points = new Point[pointNum];
        for (int i = 0; i < pointNum; i++) {
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = calculate(startPoint, points, 0, 0);
        System.out.println(min);
    }
}

class Point {
    int x;
    int y;
    boolean visited;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.visited = false;
    }
}
