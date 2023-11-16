package ED;
import ED.Node;

public class OrderedList <T> extends List implements OrderedListADT{

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

            while (current != null && data.compareTo(current.getData()) > 0) {
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

}
