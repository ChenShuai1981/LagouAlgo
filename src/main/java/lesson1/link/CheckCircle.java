package lesson1.link;

import java.util.HashSet;
import java.util.Set;

public class CheckCircle {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);

//        Node h = head;
//        h.print();

        boolean isCircle = checkCircle2(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        System.out.println(isCircle);
    }

    /**
     * 0 -> 1 -> 2 -> 3
     *      ^---------|
     *
     * @param head
     * @return
     */
    public static boolean checkCircle(Node head) {
        boolean isCircle = false;
        if (head != null) {
            Set<Node> visited = new HashSet<>();
            Node p = head;
            visited.add(p);
            while (p.getNext() != null) {
                p = p.getNext();
                if (visited.contains(p)) {
                    isCircle = true;
                    break;
                } else {
                    visited.add(p);
                }
            }
        }
        return isCircle;
    }

    /**
     * 0 -> 1 -> 2 -> 3
     *      ^---------|
     *
     * @param head
     * @return
     */
    public static boolean checkCircle2(Node head) {
        boolean isCircle = false;
        // 快指针每次跳2格
        Node p = head;
        // 慢指针每次跳1格
        Node q = head;

        while(p.getNext() != null && p.getNext().getNext() != null) {
            p = p.getNext().getNext();
            q = q.getNext();
            if (p.equals(q)) {
                isCircle = true;
                break;
            }
        }
        return isCircle;
    }
}
