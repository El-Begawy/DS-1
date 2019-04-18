package eg.edu.alexu.csd.datastructure.linkedList.cs49_cs69;

public class SingleLinkedList implements ILinkedList {
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
    public ILinkedList sublist(int fromIndex, int toIndex)
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