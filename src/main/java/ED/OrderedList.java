package ED;

public class OrderedList <T> extends List implements OrderedListADT{

    public OrderedList(){
        super();
    }

    public void add(Comparable element){

        if (size() == 0){
            add(element);
        } else {
            int i = 0;
            while (i < size() && element.compareTo(OrderedList.) > 0){
                i++;
            }
            add(i, element);
        }
    }

}
