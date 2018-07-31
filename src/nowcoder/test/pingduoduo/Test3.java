package nowcoder.test.pingduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test3 {

    private static int[] directions = {-1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        test(n);
    }

    public static int minSteps(int target) {
        List<Integer> path = new ArrayList<Integer>();
        calStep(1, target, 0, path);
        if (path.isEmpty()) {
            return -1;
        }
        Collections.sort(path);
        return path.get(0);
    }

    public static void test(int target) {
        List<Integer> path = new ArrayList<>();
        path.add(-1);
        path.add(1);
        if (Math.abs(target) == 1) {
            System.out.println(1);
            return;
        }
        boolean stop = false;
        for (int i = 2; ; i++) {
            int length = path.size() - 1;
            for (int j = 0; j < (int) Math.pow(2, i - 1); j++) {
                int val1 = path.get(length) - 1 * i;
                int val2 = path.get(length) + i;
                if (val1 == target || val2 == target) {
                    System.out.println(i);
                    stop = true;
                    break;
                }
                path.add(val1);
                path.add(val2);
                length--;
            }
            if (stop) {
                break;
            }
        }
    }

    public static void calStep(int step, int target, int position, List<Integer> path) {
        if (position == target) {
            path.add(step);
            return;
        }
        if (Math.abs(position) > Math.abs(target)) {
            return;
        }/**/
        for (int d : directions) {
            calStep(step + 1, target, position + d * step, path);
        }
    }
}