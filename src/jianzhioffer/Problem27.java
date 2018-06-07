package jianzhioffer;

import jianzhioffer.node.TreeNode;

public class Problem27 {
    //27
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
