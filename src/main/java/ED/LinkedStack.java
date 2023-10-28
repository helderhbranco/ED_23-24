package ED;

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackADT {

    /**
     * This is the reference to the top of the stack
     */
    private Node<T> top;

    /**
     * This is the number of elements in the stack
     */
    private int size;

    /**
     * This is the constructor that creates an empty stack
     */
    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }


    /**
     * Adds one element to the top of this stack.
     * @param element
     */
    @Override
    public void push(Object element) {
        Node<T> newNode = new Node(element, null);
        if (isEmpty() == true) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        size++;

    }

    /**
     * Removes and returns the top element from this stack.
     * @return Object element removed from the top of the stack
     * @throws EmptyStackException
     */
    @Override
    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node<T> temp = top;
            top = top.getNext();
            size--;
            return temp.getData();
        }
    }

    /**
     * Returns without removing the top element of this stack.
     * @return Object element on top of the stack
     * @throws EmptyStackException
     */
    @Override
    public Object peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.getData();
        }
    }

    /**
     * Returns true if this stack contains no elements.
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of elements in this stack.
     * @return int number of elements in this stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this stack.
     */
    public void print() {
        Node<T> temp = top;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();

        //PUSH
        stack.push("!");
        stack.push("World");
        stack.push("Hello");
        stack.push("Error");

        System.out.println("1ºPrint");
        stack.print();
        System.out.println("Size:" + stack.size());
        System.out.print("\n");

        //POP
        try {
            System.out.println(stack.pop());
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
        }

        System.out.println("2ºPrint (after pop)");
        stack.print();
        System.out.println("Size:" + stack.size());
        System.out.print("\n");

        //PEEK
        try {
            System.out.println("Peek: " + stack.peek());
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
        }

        System.out.println("3ºPrint (after peek)");
        stack.print();
        System.out.println("Size:" + stack.size());
        System.out.print("\n");
    }
}

//Isto agora esta no git hub
