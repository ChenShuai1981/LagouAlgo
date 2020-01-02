package lesson1.link;

public class LastKNode {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        Node h = head;
        h.print();

        Node lastKNode = lastKNode(head, 1);

        System.out.println("\n**************************");
        // 打印反转后的结果
        System.out.println(lastKNode.getData());
    }

    /**
     * 0 -> 1 -> 2 -> 3 -> null
     * @param head
     * @param lastK
     * @return
     */
    public static Node lastKNode(Node head, int lastK) {
        int k = lastK;
        // 快指针
        Node p = head;
        while((k = k-1) > 0 && p != null) {
            p = p.getNext();
        }

        // 慢指针
        Node q = head;
        while(p.getNext() != null) {
            p = p.getNext();
            q = q.getNext();
        }
        return q;
    }
}
