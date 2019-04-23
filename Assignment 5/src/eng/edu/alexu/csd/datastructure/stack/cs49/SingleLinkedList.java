package eng.edu.alexu.csd.datastructure.stack.cs49;

public class SingleLinkedList{
    public class SLLNode
    {
        public Object val;
        public SLLNode next;
    }
    private SLLNode tail,head;
    private int size=0;
    public void add(int index, Object element)
    {
        SLLNode x = new SLLNode();
        x.val=element;
        SLLNode current=head;
        SLLNode prev= null;
        while(index--!=0)
        {
            prev=current;
            current=current.next;
        }
        prev.next=x;
        x.next=current;
        size++;
    }
    public Object RemoveHead()
    {
        if(size == 0)
            throw new RuntimeException("List is empty");
        Object x = head.val;
        head=head.next;
        size--;
        return x;
    }
    public void add(Object element)
    {
        SLLNode x = new SLLNode();
        x.val = element;
        x.next = head;
        head = x;
        size++;
    }
    public Object get(int index)
    {
        SLLNode current=head;
        while(index--!=0)
        {
            current=current.next;
        }
        return current.val;
    }
    public void set(int index, Object element)
    {
        SLLNode current=head;
        while(index--!=0)
        {
            current=current.next;
        }
        current.val=element;
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
    public SingleLinkedList sublist(int fromIndex, int toIndex)
    {
        SingleLinkedList sublist = new SingleLinkedList();
        int index=0;
        SLLNode current=head;
        while(index!=fromIndex)
        {
            current=current.next;
            index++;
        }
        while(index!=toIndex)
        {
            sublist.add(index-fromIndex,current.val);
            current=current.next;
            index++;
        }
        return sublist;
    }
    public boolean contains(Object o)
    {
        SLLNode current =head;
        while(current!=null)
        {
            if(current.val == o)
                return true;
            current=current.next;
        }
        return false;
    }

}