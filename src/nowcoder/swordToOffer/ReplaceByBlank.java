package nowcoder.swordToOffer;

public class ReplaceByBlank {

    public static String replaceSpace(StringBuffer str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p1 = len - 1, p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We are Happy!");
        System.out.println(replaceSpace(sb));
    }

}
