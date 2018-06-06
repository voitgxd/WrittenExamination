package nowcoder.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int a, b;
        for (int i = 0; i < tokens.length; i++) {
            String temp = tokens[i];
            switch (temp) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push((b + a));
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    if (a == 0) {
                        return -1;
                    }
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(temp));
            }
        }
        int result = stack.peek();
        return result;
    }

    public static void main(String[] args) {
        String[] expression = {"2", "1", "+", "3", "*"};
        String[] expression2 = {"3", "-4", "+"};
        System.out.println(evalRPN(expression));
        System.out.println(evalRPN(expression2));
    }

}
