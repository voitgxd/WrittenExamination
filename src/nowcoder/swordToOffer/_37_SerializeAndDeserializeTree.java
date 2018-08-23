package nowcoder.swordToOffer;

import nowcoder.utils.TreeNode;

public class _37_SerializeAndDeserializeTree {

    private static String deserializeStr;

    public static String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public static TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private static TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

    public static void main(String[] args) {
        String str = "5 4 # 3 # 2";
        TreeNode root = Deserialize(str);
        System.out.println(Serialize(root));
    }
}
