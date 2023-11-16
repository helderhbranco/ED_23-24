package ED;

import ED.Node;


public class UnorderedList<T> extends List implements UnorderedListADT {

    public UnorderedList() {
        super();
    }


    @Override
    public void addToFront(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            newNode.setNext(getHead());
            setHead(newNode);
        }
        setCount(getCount() + 1);
    }

    @Override
    public void addToRear(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            getTail().setNext(newNode);
            setTail(newNode);
        }
        setCount(getCount() + 1);

    }

    @Override
    public void addAfter(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            newNode.setNext(getHead());
            setHead(newNode);
        }
        setCount(getCount() + 1);

    }
}
