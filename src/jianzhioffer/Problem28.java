package jianzhioffer;

import jianzhioffer.node.TreeNode;

import java.util.Stack;

public class Problem28 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return false;
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot == null) return pRoot1 == null;
        if (pRoot1 == null) return false;
        if (pRoot.val != pRoot1.val) return false;
        return isSymmetrical(pRoot.left, pRoot1.right) && isSymmetrical(pRoot.right, pRoot1.left);


    }

    //不使用递归的方法
    boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) return true;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);
        s2.push(pRoot);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();
            if(node1.val != node2.val){
                return false;
            }
            if((node1.left == null) != (node2.right == null)) return false;
            if((node2.left == null) != (node1.right == null)) return false;
            if(node1.left!=null){
                s1.push(node1.left);
            }
            if(node1.right!=null){
                s1.push(node1.right);
            }
            if(node2.right!=null){
                s2.push(node2.right);
            }
            if(node2.left!=null){
                s2.push(node2.left);
            }
        }
        return s1.isEmpty() && s2.isEmpty();
    }
}
