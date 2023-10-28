package ED;

public class LinkedList <T> {

    private Node head;

    public LinkedList() {
        head = null;
    }

    public void add(T data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void remove(T data) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.getData().equals(data)) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                break;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.print();
        System.out.println("Removing World");
        list.remove("World");
        list.print();
    }

}
