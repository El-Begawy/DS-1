package eg.edu.alexu.csd.datastructure.queue.cs49;

public class LinkedQueue implements IQueue,ILinkedBased {
    SingleLinkedList Queuelist = new SingleLinkedList();
    public void enqueue(Object item) {
        Queuelist.add(item);
    }
    public Object dequeue()
    {
        try {
            return Queuelist.RemoveHead();
        } catch (RuntimeException E)
        {
            throw new RuntimeException("Queue is empty");
        }
    }
    public boolean isEmpty()
    {
        return Queuelist.isEmpty();
    }
    public int size()
    {
        return Queuelist.size();
    }
}
