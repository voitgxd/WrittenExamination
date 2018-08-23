package nowcoder.swordToOffer;

import static nowcoder.swordToOffer._26_SubTree.Deserialize;
import nowcoder.utils.TreeNode;

public class _28_Symmetrical {

    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public static boolean isSymmetrical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
    }

    public static void main(String[] args) {
        String treeStr1 = "1,2,2,3,4,4,3";
        TreeNode node = Deserialize(treeStr1);
        System.out.println(isSymmetrical(node));
    }
}
