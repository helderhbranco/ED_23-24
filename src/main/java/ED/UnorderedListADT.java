package ED;

public interface UnorderedListADT<T> extends ListADT<T> {
    /**
     * Adds the specified element to this list at
     * the proper location
     *
     * @param data the element to be added to this list
     */
    void addToFront(T data);

    void addToRear(T data);

    void addAfter(T data);
}
