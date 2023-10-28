package ED;

import ED.Exceptions.FullStackException;

import java.util.EmptyStackException;


public class ArrayStack<T> implements StackADT<T> {

    // This is the default capacity of the stack
    private final int DEFAULT_CAPACITY = 100;

    // This is the array that will hold the stack array of generic elements to represent the stack
    private T[] stack;

    // This is the next available position in the stack
    private int top;

    // This is the constructor that creates an empty stack using the default capacity
    public ArrayStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        top = 0;
    }

    public ArrayStack(int initialCapacity) {
        stack = (T[]) new Object[initialCapacity];
        top = 0;
    }

    /*
     * Adds one element to the top of this stack.
     * @param element to be pushed onto stack
     *
     */
    @Override
    public void push(T data) throws FullStackException {
        if (size() == stack.length) {
            throw new FullStackException("Stack is full");
        } else {
            stack[top++] = data;
        }
    }

    /*
     * Removes and returns the top element from this stack.
     * @return T element removed from the top of the stack
     *
     */
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            T temp = stack[--top];
            stack[top] = null;
            return temp;
        }
    }

    /*
     * Returns without removing the top element of this stack.
     * @return T element on top of the stack
     *
     */
    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty() == true) {
            throw new EmptyStackException();
        } else {
            return stack[top -1];
        }
    }

    /*
     * Returns true if this stack contains no elements.
     * @return boolean whether or not this stack is empty
     *
     */
    @Override
    public boolean isEmpty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Returns the number of elements in this stack.
     * @return int number of elements in this stack
     *
     */
    @Override
    public int size() {
        return top;
    }

    /*
     * Returns a string representation of this stack.
     * @return String representation of this stack
     *
     */
    public void print() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        for (int i = 0; i < top; i++) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();

        //PUSH
        try {
            stack.push("!");
            stack.push("World");
            stack.push("Hello");
            stack.push("Error");
        } catch (FullStackException e) {
            System.out.println("Stack is full");
        }

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
