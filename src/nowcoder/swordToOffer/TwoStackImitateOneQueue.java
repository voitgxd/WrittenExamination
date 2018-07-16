package nowcoder.swordToOffer;

import java.util.Stack;

public class TwoStackImitateOneQueue {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void push(int node) {
        // 1. just push to stack1
        stack1.push(node);
    }

    public static int pop() {
        // 1. just pop from stack2
        // 2. if stack2 is empty, return 0
        // 3. first, push stack1's data into stack2
        if (stack1.isEmpty()) {
            return 0;
        }
        while (!stack1.isEmpty()) {
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        push(a[0]);
        push(a[1]);
        push(a[2]);
        push(a[3]);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
