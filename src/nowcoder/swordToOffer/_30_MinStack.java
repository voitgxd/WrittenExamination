package nowcoder.swordToOffer;

import java.util.Stack;

public class _30_MinStack {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty() || node < minStack.peek())
            minStack.push(node);
        else
            minStack.push(minStack.peek());
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        _30_MinStack test = new _30_MinStack();
        test.push(4);
        test.push(2);
        test.push(3);
        test.push(5);
        test.push(10);

        while (!test.dataStack.isEmpty()) {
            System.out.println(test.top() + "_" + test.min());
            test.pop();
        }

    }
}
