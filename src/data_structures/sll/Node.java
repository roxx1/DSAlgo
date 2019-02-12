package data_structures.sll;

public class Node {

    private Integer data;
    private Node next;

    public Node(Integer data, Node link) {
        this.data = data;
        this.next = link;
    }

    public Node() {
        super();
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
            "data=" + data +
            ", next=" + next +
            '}';
    }
}
