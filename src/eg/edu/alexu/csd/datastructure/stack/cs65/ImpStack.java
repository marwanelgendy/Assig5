package eg.edu.alexu.csd.datastructure.stack.cs65;

public class ImpStack implements IStack {
    StackNode top;
    int size=0;

    public Object pop()
    {
        Object x=new Object();
        x=top.getValue();
        top=top.Next;
        size--;
        return x;
    }

    public boolean isEmpty()
    {
        if (top==null)
            return true;
        return false;
    }
    public void push(Object element)
    {
        StackNode node =new StackNode(element,top);
        top=node;
        size++;
    }
    public int size()
    {
        return size;
    }
    public Object peek()
    {
        Object x=new Object();
        x=top.getValue();
        return x;
    }
    public class StackNode {
        Object value;
        StackNode Next;

        public StackNode(Object value, StackNode next) {
            this.value = value;
            Next = next;
        }

        public Object getValue() {
            return value;
        }

        public StackNode getNext() {
            return Next;
        }
    }
}
interface IStack {
    /**
     * Removes the element at the top of stack and returns that element.
     *
     * @return top of stack element.
     */
    Object pop();
    /**
     * Get the element at the top of stack without removing it from stack.
     *
     * @return top of stack element.
     */
    Object peek();

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param element to insert.
     */
    void push(Object element);

    /**
     * Tests if this stack is empty.
     *
     * @return true if stack empty.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack.
     */
    int size();
}
