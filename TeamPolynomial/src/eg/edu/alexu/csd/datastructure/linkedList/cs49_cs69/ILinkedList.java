package eg.edu.alexu.csd.datastructure.linkedList.cs49_cs69;

interface ILinkedList {
    void add(int index, Object element);
    void add(Object element);
    Object get(int index);
    void set(int index, Object element);
    void clear();
    boolean isEmpty();
    int size();
    ILinkedList sublist(int fromIndex, int toIndex);
    boolean contains(Object o);
}
