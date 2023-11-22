package ED;
import ED.Exceptions.NoSuchElementException;

import java.util.Iterator;

public class OrderedList<T extends Comparable<T>> extends List<T> implements OrderedListADT {

    public OrderedList(){
        super();
    }

    // Falta o cast para ver se o elemnto pode ser adicionado a esta lista e se é comparable
    @Override
    public void add(Comparable data) {
        Node<T> newNode = new Node(data);

        if (isEmpty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            Node<T> current = getHead();
            Node<T> previous = null;

            while (current != null && data.compareTo(current.getData()) ==0) {
                previous = current;
                current = current.getNext();
            }

            // Inserir o novo nó
            newNode.setNext(current);

            if (previous == null) {
                // O novo nó será o novo cabeça
                setHead(newNode);
            } else {
                // Inserir entre dois nós existentes
                previous.setNext(newNode);
            }

            // Se o novo nó for o último, atualizar a cauda
            if (current == null) {
                setTail(newNode);
            }
        }

        setCount(getCount() + 1);
    }

    public Iterator iterator() {
        return new ListIterator<>();
    }

    public class ListIterator<T> implements Iterator<T> {
        private int count;
        private Node<T> current;

        public ListIterator() {
            current = (Node<T>) getHead();
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

    //main para testar esta classe e o iterator

    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        Iterator<Object> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }


}
