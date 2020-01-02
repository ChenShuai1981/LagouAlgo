package lesson1.link;

public class MiddleNode {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Node h = head;
        h.print();

        Node middleNode = middleNode(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        System.out.println(middleNode.getData());
    }

    /**
     * 0 -> 1 -> (2) -> 3 -> 4 -> null
     * @param head
     * @return
     */
    public static Node middleNode(Node head) {
        // 快指针每次跳2格
        Node p = head;
        // 慢指针每次跳1格
        Node q = head;

        while(p.getNext() != null && p.getNext().getNext() != null) {
            p = p.getNext().getNext();
            q = q.getNext();
        }
        return q;
    }
}
