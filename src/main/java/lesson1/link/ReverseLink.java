package lesson1.link;

public class ReverseLink {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        h.print();
        // 调用反转方法
        head = reverse(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        head.print();
    }

    /**
     * 0 -> 1 -> 2 -> 3 -> null
     * 0 <- ()
     * 0 <- (1 <- ())
     * 0 <- (1 <- (2 <- ()))
     * 0 <- (1 <- (2 <- (3))
     * null <- 0 <- 1 <- 2 <- 3
     *
     * 递归，在反转当前节点之前先反转后续节点
     * 每一次迭代中的head都是相对的
     */
    public static Node reverse(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = reverse(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }
}
