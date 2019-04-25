package eng.edu.alexu.csd.datastructure.stack.cs49;

public interface IStack {
    public Object pop();
    public Object peek();
    public void push(Object element);
    public boolean isEmpty();
    public int size();
}