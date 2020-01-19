import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode n15 = new TreeNode(15, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode n3 = new TreeNode(3, n9, n20);
        System.out.println(solution2.levelOrder(n3));
    }
        
    private List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    @Data
    @AllArgsConstructor
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }

}
