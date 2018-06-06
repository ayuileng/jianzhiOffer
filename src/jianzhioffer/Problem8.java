package jianzhioffer;

public class Problem8 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode father = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    //中序遍历下的下一个结点
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        //右孩子不为空，直接返回右子树中的最左结点
        //右孩子为空，分两种情况 1.它是父亲的左孩子，则返回父亲；
        // 2如果是父亲的右孩子，则要找到一个是左孩子的结点，然后返回它的父亲
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            if (pNode.father == null) return null;
            if (pNode == pNode.father.left) {
                return pNode.father;
            } else {
                TreeLinkNode node = pNode.father;
                while (node.father!=null && node.father.left != node) {
                    node = node.father;
                }
                return node.father;

            }

        }
    }
}
