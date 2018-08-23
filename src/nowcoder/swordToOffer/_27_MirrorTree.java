package nowcoder.swordToOffer;

import static nowcoder.swordToOffer._26_SubTree.Deserialize;
import static nowcoder.swordToOffer._26_SubTree.Serialize;
import nowcoder.utils.TreeNode;

public class _27_MirrorTree {

    public static void Mirror(TreeNode root) {
        if(root == null)
            return;
        TreeNode tem;
        tem = root.left;
        root.left = root.right;
        root.right = tem;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        String treeStr1 = "8,6,10,5,7,9,11";
        TreeNode node = Deserialize(treeStr1);
        Mirror(node);
        System.out.println(Serialize(node));
    }
}
