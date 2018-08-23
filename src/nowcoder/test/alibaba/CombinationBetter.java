package nowcoder.test.alibaba;

import java.util.*;

public class CombinationBetter {


    /*
    一个淘宝的订单中包含n(10>=n>=1)种商品A1，A2，...，An，每种商品数量分别为a1，a2，...，an个，记做{a1,a2,...,an}(ak>0)。订单在仓库生产过程中，仓库为了提升作业效率，会提前对热门组合商品进行预包装。假设这n个商品有m(9>=m>=1)个商品组合，每个组合bomk包含A1，A2，...，An的数量分别为{b1,b2,...,bn}(bk>=0,至少存在一个bk>0)

    举例如下：

    订单包含A，B，C商品，数量为{2，3，1}，商品组合bom1{2，1，1}，bom2{1，1，0}，bom3{0，1，1}



    对以上订单匹配给定商品组合，得到的可能匹配结果为：res1.匹配到组合1一套，剩余B商品；res2.匹配到组合2两套，组合3一套，不剩商品；

    现要求订单的最优匹配，最优匹配的原则为：1.匹配组合后，剩余商品种类数越少越好；2.在剩余商品种类数相同的情况下，匹配到的组合种类数越少越好；

    例如上面例子，我们认为res2优于res1。



    现需要编写程序，输入格式为：

    n,m

    a1,a2,...,an

    bom1,b11,b12,...,b1n

    bom2,b21,b22,...,b2n

    ....

    bomm,bm1,bm2,...,bmn



    输入数据的格式说明（数据间使用英文逗号分隔）：

    第一行数据：n个商品，m个预包方案

    第二行数据：商品1个数，商品2个数，。。。，商品n个数

    第三行数据：bom1，商品1个数，商品2个数，。。。，商品n个数

    第n-1行数据：。。。。

    第n行数据：bomn，商品1个数，商品2个数，。。。，商品n个数



    针对输入数据找出最优匹配，输出最优匹配的组合及套数，比如针对上面的例子输出：

    match result:

    bom2*2，bom3*1

    注：输出结果有多个时可以乱序

    已输入字数: 1562 / 10000   运行 编程说明 -
    编译器版本: Java 1.8.0_66
    请使用标准输入输出(System.in, System.out)；已禁用图形、文件、网络、系统相关的操作，如java.lang.Process , javax.swing.JFrame , Runtime.getRuntime；不要自定义包名称，否则会报错，即不要添加package answer之类的语句；您可以写很多个类，但是必须有一个类名为Main，并且为public属性，并且Main为唯一的public class，Main类的里面必须包含一个名字为'main'的静态方法（函数），这个方法是程序的入口
    时间限制: 3S (C/C++以外的语言为: 5 S)   内存限制: 128M (C/C++以外的语言为: 640 M)
    输入:
    输入数据的格式说明（数据间使用英文逗号分隔）： 第一行数据：n个商品，m个预包方案 第二行数据：商品1个数，商品2个数，。。。，商品n个数 第三行数据：bom1，商品1个数，商品2个数，。。。，商品n个数 第n-1行数据：。。。。 第n行数据：bomn，商品1个数，商品2个数，。。。，商品n个数
    输出:
    输出最优匹配的组合及套数
    输入范例:
    3,3
    2,3,1
    bom1,2,1,1
    bom2,1,1,0
    bom3,0,1,1
    输出范例:
    match result:
    bom2*2
    bom3*1
    */
    public static void main(String[] args) {

        List<Integer> order = new ArrayList<Integer>();
        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer n = Integer.parseInt(line.split(",")[0]);
        Integer m = Integer.parseInt(line.split(",")[1]);

        line = in.nextLine();
        String[] itemCnt = line.split(",");
        for (int i = 0; i < n; i++) {
            order.add(Integer.parseInt(itemCnt[i]));
        }
        for (int i = 0; i < m; i++) {
            line = in.nextLine();
            String[] bomInput = line.split(",");
            List<Integer> bomDetail = new ArrayList<Integer>();

            for (int j = 1; j <= n; j++) {
                bomDetail.add(Integer.parseInt(bomInput[j]));
            }
            boms.put(bomInput[0], bomDetail);
        }
        in.close();
        Map<String, Integer> res = resolve(order, boms);

        System.out.println("match result:");
        for (String key : res.keySet()) {
            System.out.println(key + "*" + res.get(key));
        }
    }

    // write your code here
    public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        return map;
    }

}
