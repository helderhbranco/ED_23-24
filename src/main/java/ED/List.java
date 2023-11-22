package ED;

import ED.Exceptions.ElementNotFoundException;
import ED.Exceptions.EmptyCollectionException;
import ED.Exceptions.NoSuchElementException;

import java.util.Iterator;

/**
 * List.java
 * <p>
 * This abstract class provides a partial implementation of the List interface.
 *
 * @param <T>
 */


public abstract class List<T> implements ListADT {
    private int count;
    private Node<T> head, tail;

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setHead(Node<T> head) { this.head = head;}

    public void setTail(Node<T> tail) { this.tail = tail;}
    public int getCount() { return count;}

    public void setCount(int count) { this.count = count;}

    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A coleção está vazia");
        }
        T result = head.getData();
        head = head.getNext();
        count--;
        if (isEmpty()) {
            tail = null;
        }
        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A coleção está vazia");
        }
        T result = tail.getData();
        Node<T> previous = null;
        Node<T> current = head;
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            head = null;
        } else {
            previous.setNext(null);
            tail = previous;
        }
        count--;
        return result;
    }

    @Override
    public T remove(Object data) throws ElementNotFoundException, EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A coleção está vazia");
        }
        boolean found = false;
        Node<T> previous = null;
        Node<T> current = head;
        while (current != null && !found) {
            if (data.equals(current.getData())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        if (!found) {
            throw new ElementNotFoundException("List");
        }
        if (size() == 1) {
            head = tail = null;
        } else if (current.equals(head)) {
            head = current.getNext();
        } else if (current.equals(tail)) {
            tail = previous;
            tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }
        count--;
        return current.getData();
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A coleção está vazia");
        }
        return head.getData();
    }

    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A coleção está vazia");
        }
        return tail.getData();
    }

    public boolean contains(Object target) throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A coleção está vazia");
        }
        boolean found = false;
        Node<T> current = head;
        while (current != null && !found) {
            if (target.equals(current.getData())) {
                found = true;
            } else {
                current = current.getNext();
            }
        }
        return found;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int size() {
        return count;
    }

    public String toString() {
        String result = "";
        Node<T> current = head;
        while (current != null) {
            result = result + (current.getData()).toString() + "\n";
            current = current.getNext();
        }
        return result;
    }

    public Iterator<Object> iterator() {
        return new ListIterator<>();
    }

    public class ListIterator<T> implements Iterator<T> {
        private int count;
        private Node<T> current;

        public ListIterator() {
            current = (Node<T>) head;
            count = 0;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public T next() {
            try {
                if (!hasNext()) {
                    throw new NoSuchElementException("No such element");
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            T result = current.getData();
            current = current.getNext();
            count++;
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


    }
}
