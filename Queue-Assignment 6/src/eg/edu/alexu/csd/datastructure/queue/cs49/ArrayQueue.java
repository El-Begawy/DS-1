package eg.edu.alexu.csd.datastructure.queue.cs49;

public class ArrayQueue implements IQueue,IArrayBased {
    private int l = 0,r = 0;
    private int capacity;
    private Object[] queArray;

    ArrayQueue(int n)
    {
        this.queArray = new Object[n];
        this.capacity = n;
    }
    private int size = 0;
    public void enqueue(Object item) {
        if(size == capacity)
            throw new RuntimeException("Queue is full");
        queArray[r] = item;
        r = (r+1)%capacity;
        size++;
    }
    public Object dequeue()
    {
        if(isEmpty())
            throw new RuntimeException("Queue is empty");
        Object temp = queArray[l];
        l = (l + 1) % capacity;
        size--;
        return temp;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public int size()
    {
        return size;
    }
}
