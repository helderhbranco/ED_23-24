package ED;

public class LinkedQueue implements  QueueADT{

private Node front;
    private Node rear;
    private int size;

    public LinkedQueue(){
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(Object data) {
        Node newNode = new Node(data, null);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object result = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return result;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            return null;
        }
        return front.getData();
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        String result = "";
        Node current = front;
        while(current != null){
            result += current.getData() + "\n";
            current = current.getNext();
        }
        return result;
    }


    public static void main(String[] args) {

        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("Maria");
        queue.enqueue("Joao");
        queue.enqueue("Manel");
        System.out.println(queue);

        System.out.println("First: " + queue.first());

        queue.dequeue();

        System.out.println(queue);
        System.out.println("First: " + queue.first());
    }


}
