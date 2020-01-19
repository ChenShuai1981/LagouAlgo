import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给出两棵二叉搜索树，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。
 */
public class Solution1214 {
    public static void main(String[] args) {
        TreeNode n10z = new TreeNode(-10, null, null);
        TreeNode n10 = new TreeNode(10, null, null);
        TreeNode tn1 = new TreeNode(0, n10z, n10);

        TreeNode n0 = new TreeNode(0, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n2 = new TreeNode(2, null, null);
        TreeNode n1 = new TreeNode(1, n0, n2);
        TreeNode tn2 = new TreeNode(5, n1, n7);

        System.out.println(match(tn1, tn2, 18));
    }
    
    public static boolean match(TreeNode tn1, TreeNode tn2, int target) {
        boolean found = false;
        List<Integer> list = access(tn1);
        for (Integer a : list) {
            int b = target - a;
            if (search(tn2, b)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static List<Integer> access(TreeNode tn) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(tn);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i=0; i<queueSize; i++) {
                TreeNode head = queue.poll();
                list.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
        }
        return list;
    }

    public static boolean search(TreeNode tn, int target) {
        if (tn.val == target) return true;
        if (tn.val > target) {
            if (tn.left != null) {
                return search(tn.left, target);
            } else {
                return false;
            }
        } else {
            if (tn.right != null) {
                return search(tn.right, target);
            } else {
                return false;
            }
        }
    }

    @Data
    @AllArgsConstructor
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
