package nowcoder.swordToOffer;

import nowcoder.utils.TreeUtil;
import nowcoder.utils.TreeNode;

import java.util.*;

public class _34_FindPathSumEqualOneVal {

    private static Deque<Integer> deque = new LinkedList<>();
    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        printPath2(root, target);
        return result;
    }

    public static void printPath2(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        deque.addLast(root.val);
        System.out.println(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            Integer[] temp = new Integer[deque.size()];
            deque.toArray(temp);
            result.add(new ArrayList<Integer>(Arrays.asList(temp)));
        }
        printPath2(root.left, target);
        printPath2(root.right, target);
        deque.pollLast();
    }

    public static void printPath(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        deque.addLast(root.val);
        Integer[] temp = new Integer[deque.size()];
        deque.toArray(temp);
        if (sum(temp) == target && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(Arrays.asList(temp)));
        }
        printPath(root.left, target);
        printPath(root.right, target);
        deque.pollLast();
    }

    public static int sum(Integer[] list) {
        int result = 0;
        for (int i : list) {
            result += i;
        }
        return result;
    }

    public static void printTree(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        deque.addLast(root.val);
        if (root.left == null && root.right == null) {
            System.out.println(deque.toString());
        }
        printTree(root.left, target);
        printTree(root.right, target);
        System.out.println(root.val);
        deque.pollLast();
    }

    public static void main(String[] args) {
        String str = "10,5,12,4,7";
        TreeNode root = TreeUtil.layerDeserialize(str);
        ArrayList<ArrayList<Integer>> res = FindPath(root, 15);
        for (ArrayList<Integer> tem : res) {
            System.out.println(tem.toString());
        }
    }
}
