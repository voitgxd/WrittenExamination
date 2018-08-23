package nowcoder.swordToOffer;

import nowcoder.utils.TreeUtil;
import nowcoder.utils.TreeNode;

import java.util.*;

public class _32_3_LayerPrintTree {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean printFromLeftToRight = true;
        while (!queue.isEmpty()) {
            int curQueueSize = queue.size();
            ArrayList<Integer> tem = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            while (curQueueSize > 0) {
                TreeNode node = queue.poll();
                if (printFromLeftToRight)
                    tem.add(node.val);
                else
                    stack.push(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                curQueueSize--;
            }
            printFromLeftToRight = !printFromLeftToRight;
            while (!stack.isEmpty()) {
                tem.add(stack.pop());
            }
            result.add(tem);
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean printFromLeftToRight = false;
        while (!queue.isEmpty()) {
            int curQueueSize = queue.size();
            ArrayList<Integer> tem = new ArrayList<>();
            while (curQueueSize > 0) {
                TreeNode node = queue.poll();
                tem.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                curQueueSize--;
            }
            if (printFromLeftToRight)
                Collections.reverse(tem);
            printFromLeftToRight = !printFromLeftToRight;
            result.add(tem);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        TreeNode root = TreeUtil.layerDeserialize(str);
        ArrayList<ArrayList<Integer>> result = Print2(root);
        for (ArrayList<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
