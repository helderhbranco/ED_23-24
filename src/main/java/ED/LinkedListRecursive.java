package ED;

public class LinkedListRecursive<T> extends LinkedList {

    public LinkedListRecursive() {
        super();
    }

    public void printRecursive(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        printRecursive(node.getNext());
    }


    public static void main(String[] args) {
        LinkedListRecursive<Integer> list = new LinkedListRecursive<>();
        list.add("Helder");
        list.add("Bruno");
        list.add("Lucas");
        list.add("João");
        list.printRecursive(list.getNext());
    }

}
