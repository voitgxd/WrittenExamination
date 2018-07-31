package nowcoder.test.pingduoduo;

import java.util.*;

public class Test2 {

    public static String generateStr(String str, int len) {
        StringBuffer sb = new StringBuffer();
        char[] array = str.toCharArray();
        for (int i = 0; i < len; i++) {
            sb.append(array[i % str.length()]);
        }
        return sb.toString();
    }

    public static String getMaxRep(String input) {
        if (input == null) {
            return null;
        }
        char[] strArr = input.toCharArray();
        int maxLen = strArr.length;
        for (int i = 1; i < strArr.length; i++) {
            String tem = input.substring(0, i);
            String resTem = generateStr(tem, input.length());
            if (resTem.equals(input)) {
                maxLen = i;
                break;
            }
        }
        return input.substring(0, maxLen);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getMaxRep(str));
    }
}
