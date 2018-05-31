package nowcoder.leetcode;

import java.util.HashMap;

public class MaxPointsOnALine {

    /**
     * 平面里确定一条直线要两个数据，可以是两个不同的点(高中数学做法)，也可以是一个点加一个斜率(这道题做法)
     *
     * 斜率k = (y2 - y1)/(x2 - x1)，当 x1 == x2 时，分母为0，斜率为无穷，表示和y轴平行的直线们
     *
     * 在计算机里使用double表示斜率，是不严谨的也是不正确的，double有精度误差，double是有限的，斜率是无限的，无法使用有限的double表示无限的斜率，不过此题的test case没有涉及这个问题
     *
     * 表示斜率最靠谱的方式是用最简分数，即分子分母都无法再约分了。分子分母同时除以他们的最大公约数gcd即可得到最简分数
     *
     * gcd(a,b)，一般求的是两个正整数的gcd。这道题a和b有可能是0，分别表示与x轴或y轴平行的斜率(注意ab不能同时为0,表示同一个点没有意义)，所以这道题我们规定ab取值范围：a>=0,b>=0。至于负数，先变成正数取gcd，再确定最终斜率的正负
     *
     * gcd ( a , b ) = (b == 0) ? a : gcd ( b , a % b ), a,b是任意非负整数且a,b至少有一个不为0
     *
     * 观察gcd(a,b)，假设a,b为非负整数：
     *
     * a和b中有一个为零，那么gcd为另一个不为0的数；
     *
     * a和b都为0，gcd为0；
     * @param points
     * @return
     */

    public static int maxPoints(Point[] points) {
        if (points.length <= 1)
            return points.length;
        int maxUniv = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            Point cur = points[i];
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int howManyCur = 1, maxLocal = 0;
            for (int j = i + 1; j < points.length; j++) {   //这里可以从i+1开始，之前的都算过了
                Point iter = points[j];
                if (iter.x == cur.x && iter.y == cur.y) {//同一顶点
                    howManyCur += 1;
                } else {          //不同顶点
                    String key = getSlopeInString(cur, iter);
                    //map里存(过cur点,斜率key)代表的直线有多少除了cur的点
                    map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
                    maxLocal = Math.max(maxLocal, map.get(key));
                }
            }
            maxLocal = howManyCur + maxLocal;
            maxUniv = Math.max(maxLocal, maxUniv);
        }
        return maxUniv;
    }

    public static String getSlopeInString(Point cur, Point iter) {
        int numerator = iter.y - cur.y;
        int denominator = iter.x - cur.x;
        String sign = getSign(numerator, denominator);
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));//0和任意一个非零数'a'的gcd为'a',0和0的gcd为0,所以斜率为无穷的情况分母为0
        return sign + Math.abs(numerator) / gcd + "/" + Math.abs(denominator) / gcd;
    }

    //a和b为非负整数 且 a和b不同时为0
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static String getSign(int a, int b) {
        if (a <= 0 && b <= 0 || a >= 0 && b >= 0)
            return "+";
        else
            return "-";
    }

    public static void main(String[] args) {
        // [(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]
        Point p1, p2, p3, p4, p5, p6, p7, p8, p9;
        p1 = new Point(84, 250);
        p2 = new Point(0, 0);
        p3 = new Point(1, 0);
        p4 = new Point(0, -70);
        p5 = new Point(0, -70);
        p6 = new Point(1, -1);
        p7 = new Point(21, 10);
        p8 = new Point(42, 90);
        p9 = new Point(-42, -230);
        Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8, p9};
        System.out.println(maxPoints(points));
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}