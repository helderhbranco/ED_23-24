package ED;

public class Node<T> {


    private T data;
    private Node<T> next; // a link to another Node object
    private Node<T> previous; // a link to another Node object

    public Node(T data, Node<T> next, Node<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;

    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = null;
    }

    public Node(T data) {
    }


    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

}
