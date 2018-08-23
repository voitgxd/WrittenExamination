package nowcoder.swordToOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class _38_Permutation {
    private static ArrayList<String> result = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return result;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        permutation(chars, new boolean[chars.length], new StringBuffer());
        return result;
    }

    public static void permutation(char[] array, boolean[] isUserd, StringBuffer tem) {
        if (array.length == tem.length()) {
            result.add(tem.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (isUserd[i])
                continue;
            isUserd[i] = true;
            tem.append(array[i]);
            permutation(array, isUserd, tem);
            tem.deleteCharAt(tem.length() - 1);
            isUserd[i] = false;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> ret = Permutation("abc");
        for (String str : ret)
            System.out.println(str);
    }
}
