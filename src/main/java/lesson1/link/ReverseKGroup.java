package lesson1.link;

public class ReverseKGroup {

    public static void main(String[] args) throws Exception {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);

        Node head = node1;
        head.print();
        // 调用反转方法
        head = reverseKGroup(head, 3);

        System.out.println("\n**************************");
        // 打印反转后的结果
        head.print();
    }

    /**
     * LeeCode 25
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 示例：
     * 给定这个链表：1->2->3->4->5
     * 当 k=2 时，应当返回：2->1->4->3->5
     * 当 k=3 时，应当返回：3->2->1->4->5
     *
     * 假设N个节点，按K个一组划分
     *
     * 算法复杂度是
     * 最优情况是节点全部分组，反转次数: (K-1)*(N/K)
     * 最差情况是差一个不够分组，需要再次反转成正序：(K-1)*(N/K - 1) + 2*(K-2)
     * 平均算法复杂度是 O(N)
     *
     * 空间复杂度是 O(1)
     *
     * @param head
     * @param k
     * @return
     */
    public static Node reverseKGroup(Node head, int k) throws Exception {
        int n = k;
        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null && n-- > 0) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        if (curr == null) { // 到链表末尾了
            if (n == 0) { // 刚好全部分组
                return prev;
            } else { // 不够分组，那么将prev再次反转成原来的正序
                return ReverseLink.reverse(prev);
            }
        } else {
            // 否则继续递归下去，返回反转后新的head
            head.setNext(reverseKGroup(curr, k));
            return prev;
        }
    }

}
