package nowcoder.test.test_java;


public class PrintNumByDicOrder {

    public static void func1(int n) {
        int total = 0;//记录输出多少个数
        int begin = 0;
        while (total < n) {
            if (begin <= n) {
                System.out.println(begin);
                total++;
                if (begin == 0)
                    ++begin;
                else
                    begin *= 10;
            } else {
                begin = begin / 10 + 1;
                while (begin != 0 && begin % 10 == 0)
                    begin /= 10;
            }
        }
    }

    public static void main(String[] args) {
        func1(121);
    }

}
