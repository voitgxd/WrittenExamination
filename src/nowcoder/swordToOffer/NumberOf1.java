package nowcoder.swordToOffer;

public class NumberOf1 {

    public static int numberOf1(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n &= n - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(-10));
    }
}
