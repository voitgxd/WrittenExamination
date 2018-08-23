package nowcoder.swordToOffer;

import nowcoder.utils.TreeUtil;
import nowcoder.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _32_1_LayerPrintTree {

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        TreeNode root = TreeUtil.layerDeserialize(str);
        ArrayList<Integer> result = PrintFromTopToBottom(root);
        for (int i : result)
            System.out.println(i);
    }
}
