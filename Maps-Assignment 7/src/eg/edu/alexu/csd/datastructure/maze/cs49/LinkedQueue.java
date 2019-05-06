package eg.edu.alexu.csd.datastructure.maze.cs49;

public class LinkedQueue{
    private class SingleLinkedList{
        public class SLLNode
        {
            public Object val;
            public SLLNode next;
        }
        private SLLNode tail,head;
        private int size=0;
        public void add(Object element)
        {
            SLLNode x = new SLLNode();
            x.val=element;
            if(size==0)
                head=x;
            else if(size==1)
            {
                tail=x;
                head.next=tail;
            }
            else
            {
                tail.next=x;
                tail=x;
            }
            size++;
        }
        public Object RemoveHead()
        {
            if(isEmpty())
                throw new RuntimeException("List is empty");
            SLLNode temp = head;
            head = head.next;
            size--;
            return temp.val;
        }
        public void clear()
        {
            size=0;
            head=tail=null;
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
    private SingleLinkedList Queuelist = new SingleLinkedList();
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
