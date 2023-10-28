package ED;

public class Double_LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public Double_LinkedList() {
        head = null;
        tail = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void remove(T data) {
        Node<T> current = head;
        Node<T> previous = null;
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
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

        public static void main(String[] args) {
            Double_LinkedList<String> list = new Double_LinkedList<>();
            list.add("Hello");
            list.add("World");
            list.add("!");
            list.print();
            System.out.println("Removing World");
            list.remove("World");
            list.print();
        }
}
