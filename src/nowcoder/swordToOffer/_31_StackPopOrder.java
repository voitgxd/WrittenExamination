package nowcoder.swordToOffer;

import java.util.Stack;

public class _31_StackPopOrder {

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < pushA.length; pushIndex++) {
            stack.add(pushA[pushIndex]);
            while (popIndex < popA.length && !stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String order = "1,2,3,4,5";
        String[] strs = order.split(",");
        int[] elements = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            elements[i] = Integer.parseInt(strs[i]);
        }
        int[] popA = {1, 2, 3, 4, 5};
        System.out.println(IsPopOrder(elements, popA));
    }
}
