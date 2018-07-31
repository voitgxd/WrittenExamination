package nowcoder.test.pingduoduo;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputs = scan.nextLine();
        if (!inputs.startsWith("[")) {
            System.out.println(0);
            return;
        }

        if (!inputs.endsWith("]")) {
            System.out.println(0);
            return;
        }
        inputs = inputs.substring(1, inputs.length() - 1);
        if (inputs.length() < 3) {
            System.out.println(0);
            return;
        }
        String str[] = inputs.split(",");
        int a[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        int left = 0;
        int cur = 1;
        int right;
        if (a.length < 3) {
            System.out.println(0);
            return;
        }
        int max = 0;
        for (cur = 1; cur < a.length - 1; cur++) {
            left = cur - 1;
            right = cur + 1;
            if (a[left] <= a[cur]) {
                continue;
            }
            if (a[right] <= a[cur]) {
                continue;
            }
            while (left > 0) {
                if (a[left] < a[left - 1]) {
                    left--;
                } else {
                    break;
                }
            }
            while (right < a.length - 1) {
                if (a[right] < a[right + 1]) {
                    right++;
                } else {
                    break;
                }
            }
            int temp = right - left + 1;

            if (max < temp && temp >= 3) {
                max = temp;
            }
        }
        System.out.println(max);
    }
}
