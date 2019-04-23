package eng.edu.alexu.csd.datastructure.stack.cs49;

public class Stack implements IStack {
    SingleLinkedList Stack = new SingleLinkedList();
    public Object pop()
    {
        if(Stack.isEmpty())
            throw new RuntimeException("Stack is empty");
        return Stack.RemoveHead();
    }
    public Object peek()
    {
        if(Stack.isEmpty())
            throw new RuntimeException("Stack is empty");
        return Stack.get(0);
    }
    public void push(Object x)
    {
        Stack.add(x);
    }
    public boolean isEmpty()
    {
        return Stack.isEmpty();
    }
    public int size()
    {
        return Stack.size();
    }
}
