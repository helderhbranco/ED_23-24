package ED;
import ED.Node;


public class UnorderedList <T> extends List implements UnorderedListADT {

    public UnorderedList(){
        super();
    }


    @Override
    public void addToFront(T data) {
        Node newNode = new Node();
        newNode.setNext(getHead());
        setHead(newNode);
        if (getTail() == null){
            setTail(newNode);
        }
        setCount(getCount() + 1);
    }

    @Override
    public void addToRear(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()){
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        count++;


    }

    @Override
    public void addAfter(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head.getNext());
            head.setNext(newNode);
        }

    }
}
