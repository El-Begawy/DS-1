package eg.edu.alexu.csd.datastructure.queue.cs49;

public class SingleLinkedList{
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