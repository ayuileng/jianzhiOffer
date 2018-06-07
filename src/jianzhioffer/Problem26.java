package jianzhioffer;

import jianzhioffer.node.TreeNode;

public class Problem26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if(isSame(root1,root2)){
            return true;
        }else{
            return isSame(root1.left,root2) ||isSame(root1.right,root2);
        }

    }

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) {
            return false;
        } else {
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        }

    }

}
