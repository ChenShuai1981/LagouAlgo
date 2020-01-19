import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    public static void main(String[] args) {
        TreeNode n15 = new TreeNode(15, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode n3 = new TreeNode(3, n9, n20);
        List<List<Integer>> result = levelIterateBinaryTree(n3);
        System.out.println(result);
    }

    public static List<List<Integer>> levelIterateBinaryTree(TreeNode treeNode) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(treeNode);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int queueSize = queue.size();
            for (int i=0; i<queueSize; i++) {
                TreeNode head = queue.poll();
                list.add(head.data);
                if (result.size() % 2 == 1) {
                    if (head.left != null) {
                        queue.offer(head.left);
                    }
                    if (head.right != null) {
                        queue.offer(head.right);
                    }
                } else {
                    if (head.right != null) {
                        queue.offer(head.right);
                    }
                    if (head.left != null) {
                        queue.offer(head.left);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }

    @Data
    @AllArgsConstructor
    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
    }
}
