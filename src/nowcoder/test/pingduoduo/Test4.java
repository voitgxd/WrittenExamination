package nowcoder.test.pingduoduo;

import java.util.*;

public class Test4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        String nlll = scan.nextLine();
        String phone = scan.nextLine();
        if (k > n) {
            return;
        }

        char[] chs = phone.toCharArray();
        int[] numers = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            numers[i] = Integer.parseInt(String.valueOf(chs[i]));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iter = keySet.iterator();

        for (int i = 0; i < numers.length; i++) {
            if (!map.containsKey(numers[i])) {
                map.put(numers[i], 1);
            } else {
                map.put(numers[i], map.get(numers[i]) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int item : numers) {
            list.add(item);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int item : numers) {
            list2.add(item);
        }
        Collections.sort(list);
        int cost_final = 500000000;
        ArrayList<Integer> list_final = new ArrayList<>();
        for (int item : map.keySet()) {
            list2.clear();
            for (int aaaa : numers) {
                list2.add(aaaa);
            }
            int cost = 0;
            int l_k = map.get(item);
            int temp_index = list.indexOf(item);
            int left = temp_index - 1;
            int right = temp_index + map.get(item);
            for (int i = 0; i < k - l_k; i++) {
                int cost_temp1 = 500000000;
                int cost_temp2 = 500000000;
                if (left >= 0) {
                    cost_temp1 = Math.abs(list.get(left) - item);
                }
                if (right < list.size()) {
                    cost_temp2 = Math.abs(list.get(right) - item);
                }
                if (cost_temp1 < cost_temp2) {
                    cost += cost_temp1;
                    list2.set(list2.indexOf(list.get(left)), item);
                    left--;
                } else if (cost_temp1 > cost_temp2) {
                    cost += cost_temp2;
                    list2.set(list2.indexOf(list.get(right)), item);
                    right++;
                }
            }

            if (cost < cost_final) {
                list_final.clear();
                for (int int_item : list2) {
                    list_final.add(int_item);
                }
                cost_final = cost;
            }
        }

        System.out.println(cost_final);
        for (int item : list_final) {
            System.out.print(item);
        }
        System.out.println();

    }
}
