package nowcoder.swordToOffer;

import nowcoder.utils.TreeNode;
import nowcoder.utils.TreeUtil;

public class _36_ConvertBSTToDDL {

    public static TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode node = ConvertCore(pRootOfTree);
        while (node != null && node.left != null)
            node = node.left;
        return node;
    }

    public static TreeNode ConvertCore(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode right = Convert(pRootOfTree.right);
        while (left != null && left.right != null)
            left = left.right;
        if (left != null) {
            if (pRootOfTree.right == left)
                left.left = pRootOfTree;
            else {
                left.right = pRootOfTree;
                pRootOfTree.left = left;
            }
        }
        while (right != null && right.left != null)
            right = right.left;
        if (right != null) {
            if (pRootOfTree.right == right)
                right.left = pRootOfTree;
            else {
                pRootOfTree.right = right;
                right.left = pRootOfTree;
            }

        }
        return pRootOfTree;
    }

    public static void main(String[] args) {
        String str = "10,6,14,4,8,12,16";
        TreeNode root = TreeUtil.layerDeserialize(str);
        TreeNode node = Convert(root);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }
}