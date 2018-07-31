package nowcoder.test.shenxinfu;

import java.util.Scanner;

public class Test4 {

    public static int maxRep(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int max = 0, first = 0, k = 0;
        for (int i = 1; i < input.length(); i++) {
            for (int j = 0; j < input.length() - i; j++) {
                if (input.charAt(j) == input.charAt(i + j)) {
                    k++;
                } else {
                    k = 0;
                }
                if (k > max) {
                    max = k;
                    first = j - k + 1;
                }
            }
        }
        int result = 0;
        if (max > 0) {
            String test = input.substring(first, first + max);
            if (maxRep(test) == 2) {
                result = max * 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(maxRep(str));
    }
}
