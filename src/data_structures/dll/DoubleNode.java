package data_structures.dll;

public class DoubleNode {

    private Integer data;
    private DoubleNode prev;
    private DoubleNode next;

    public DoubleNode(Integer data, DoubleNode prev, DoubleNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DoubleNode(Integer data) {
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}
