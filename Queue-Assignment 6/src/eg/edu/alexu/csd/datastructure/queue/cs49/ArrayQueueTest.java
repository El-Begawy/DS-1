package eg.edu.alexu.csd.datastructure.queue.cs49;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayQueueTest {
    ArrayQueue R = new ArrayQueue(3);

    @org.junit.jupiter.api.Test
    void enqueue() {
        R.enqueue(5);
        R.enqueue(3);
        R.enqueue(10);
        assertThrows(RuntimeException.class, () -> R.enqueue(20));
    }
    @org.junit.jupiter.api.Test
    void dequeue() {
        R.enqueue(5);
        R.enqueue(3);
        assertEquals(5,R.dequeue());
        assertEquals(3,R.dequeue());
        assertThrows(RuntimeException.class, () -> R.dequeue());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertEquals(true,R.isEmpty());
        R.enqueue(3);
        assertEquals(false,R.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0,R.size());
        R.enqueue(4);
        assertEquals(1,R.size());
        R.dequeue();
        assertEquals(0,R.size());
    }
}