package ED;

public class CircularArrayQueue implements QueueADT {

    private final int FARTOR = 2;
    private final int DEFAULTCAPACITY = 10;

    private Object[] queue;
    private int front;
    private int rear;
    private int size;


    public CircularArrayQueue() {
        queue = new Object[DEFAULTCAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    public CircularArrayQueue(int capacity) {
        queue = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void enqueue(Object data) {
        expandCapacity();
        queue[rear] = data;
        rear = (rear + 1) % queue.length;
        size++;
    }

    @Override
    public Object dequeue() throws NullPointerException {
        if (isEmpty()) {
            return null;
        }
        Object result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return result;
    }

    @Override
    public Object first() throws NullPointerException {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
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
    public String toString() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        String result = "";
        for (int i = 0; i < size; i++) {
            result += queue[(front + i) % queue.length] + " ";
        }
        return result;
    }

    private void expandCapacity() {
        if (size == queue.length) {

            Object[] newQueue = new Object[queue.length * FARTOR];
            for (int i = 0; i < size; i++) {
                newQueue[i] = queue[(front + i) % queue.length];
            }
            queue = newQueue;
            front = 0;
            rear = size;
        }
    }

    public static void main(String[] args) {
        CircularArrayQueue queue = new CircularArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.toString();
        queue.dequeue();
        queue.dequeue();
        queue.toString();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.toString();
    }
}
