package nowcoder.swordToOffer;

import nowcoder.utils.TreeNode;
import nowcoder.utils.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _32_2_LayerPrintTree {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> tem = new ArrayList<>();
            int curNodeNum = queue.size();
            while (curNodeNum > 0) {
                TreeNode node = queue.poll();
                tem.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                curNodeNum--;
            }
            result.add(tem);

        }
        return result;
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        TreeNode root = TreeUtil.layerDeserialize(str);
        ArrayList<ArrayList<Integer>> result = Print(root);
        for (ArrayList<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
