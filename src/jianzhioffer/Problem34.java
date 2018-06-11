package jianzhioffer;

import jianzhioffer.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem34 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size() - 1);
        return result;
    }


}
