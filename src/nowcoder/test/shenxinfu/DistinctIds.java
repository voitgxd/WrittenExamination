package nowcoder.test.shenxinfu;

import java.util.*;

public class DistinctIds {

    public static void distinct(int[] a) {
        if (a[0] == 0) {
            System.out.println(0);
            return;
        }
        int temp = a[0];
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < a.length; i++) {
            if(a[i] != temp){
                result.add(temp);
                temp = a[i];
            }
        }
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        if (n < 1 || n > 100000) {
//            System.out.println(0);
//            return;
//        }
//        int id;
//        Set<Integer> distinctIds = new HashSet<Integer>();
//        Deque<Integer> queue = new LinkedList<Integer>();
//        for (int i = 0; i < n; i++) {
//            id = sc.nextInt();
//            if (id < 1 || id > 1000 || distinctIds.contains(id)) {
//                continue;
//            }
//            distinctIds.add(id);
//            queue.add(id);
//        }
//        System.out.println(queue.size());
//        while (!queue.isEmpty()) {
//            id = queue.peekFirst();
//            queue.pollFirst();
//            System.out.println(id);
//        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1 || n > 100000) {
            System.out.println(0);
            return;
        }
        int[] ids = new int[100000];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            if (id < 1 || id > 1000) {
                continue;
            }
            ids[i] = id;
        }
        distinct(ids);
    }
}