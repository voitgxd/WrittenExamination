package nowcoder.swordToOffer;

public class _20_NumberStr {

    public static boolean isNumeric(char[] str) {
        if (str == null)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        // "+100","5e2","-123","3.1416" 和 "-1E-16"
        // "12e","1a3.14","1.2.3","+-5" 和 "12e+4.3"

        //正则规则：
        // []  ： 字符集合,匹配任意一个
        // ()  ： 分组，在这里是为了让表达式更清晰
        // ?   ： 重复 0 ~ 1
        // +   ： 重复 1 ~ n
        // *   ： 重复 0 ~ n
        // .   ： 任意字符
        // \\. ： 转义后的 .
        // \\d ： 任意数字
        System.out.println(isNumeric("-000001E+16".toCharArray()));
    }
}
