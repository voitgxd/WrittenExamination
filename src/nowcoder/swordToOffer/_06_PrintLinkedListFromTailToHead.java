package nowcoder.swordToOffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class PrintLinkedListFromTailToHead {
    // 四种方法：
    // 1.栈
    // 2.递归
    // 3.Collections
    // 4.使用头插法

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode != null) {
            Stack<Integer> stack = new Stack<>();
            ListNode p = listNode;
            while (p != null) {
                stack.push(p.val);
                p = p.next;
            }
            while (!stack.empty()) {
                int val = stack.pop();
                result.add(val);
            }
        }
        return result;
    }

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode != null) {
            ListNode p = listNode;
            while (p != null) {
                result.add(p.val);
                p = p.next;
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        addValToList(listNode, result);
        return result;
    }

    public static void addValToList(ListNode listNode, ArrayList<Integer> result) {
        if (listNode != null) {
            addValToList(listNode.next, result);
            result.add(listNode.val);
        }
    }

    public static ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ListNode resultList = null;
        if (listNode != null) {
            ListNode p = listNode;
            while (p != null) {
                ListNode tempNode = new ListNode(p.val);
                tempNode.next = resultList;
                resultList = tempNode;
                p = p.next;
            }
        }
        ListNode p = resultList;
        while (p != null) {
            result.add(p.val);
            p = p.next;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ArrayList<Integer> result = printListFromTailToHead4(n1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
