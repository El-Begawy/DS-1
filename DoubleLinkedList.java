package eg.edu.alexu.csd.datastructure.linkedList.cs49_cs69;

public class DoubleLinkedList implements ILinkedList {
    public class DLLNode
    {
        public Object val;
        public DLLNode next;
        public DLLNode prev;
    }
    private DLLNode tail,head;
    private int size=0;
    public void add(int index, Object element)
    {
        DLLNode x = new DLLNode();
        x.val=element;
        DLLNode current=head;
        DLLNode prev= null;
        while(index--!=0)
        {
            prev=current;
            current=current.next;
        }
        prev.next=x;
        x.next=current;
        x.prev=prev;
        current.prev = x;
        size++;
    }
    public void add(Object element)
    {
        DLLNode x = new DLLNode();
        x.val=element;
        if(size==0)
            head=x;
        else if(size==1)
        {
            tail=x;
            head.next=tail;
            tail.prev=head;
        }
        else
        {
            tail.next=x;
            x.prev=tail;
            tail = x;
        }
        size++;
    }
    public Object get(int index)
    {
        DLLNode current=head;
        while(index--!=0)
        {
            current=current.next;
        }
        return current.val;
    }
    public void set(int index, Object element)
    {
        DLLNode current=head;
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
        DoubleLinkedList sublist = new DoubleLinkedList();
        int index=0;
        DLLNode current=head;
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
        DLLNode current =head;
        while(current!=null)
        {
            if(current.val == o)
                return true;
            current=current.next;
        }
        return false;
    }
}
