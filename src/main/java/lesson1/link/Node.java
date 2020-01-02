package lesson1.link;

import lombok.Data;

@Data
public class Node {
    public int data;// 数据域
    public Node next;// 指针域

    public Node(int data) {
        // super();
        this.data = data;
    }

    public void print() {
        Node node = this;
        while (null != node) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Node)) {
            return false;
        }
        Node anotherNode = (Node) object;
        return this.getData() == anotherNode.getData();
    }

}
