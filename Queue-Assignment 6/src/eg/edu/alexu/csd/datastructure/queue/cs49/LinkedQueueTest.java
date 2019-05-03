package eg.edu.alexu.csd.datastructure.queue.cs49;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {
    LinkedQueue R = new LinkedQueue();
    @Test
    void enqueue() {
        R.enqueue(10);
        R.enqueue(20);
        assertEquals(10,R.dequeue());
    }

    @Test
    void dequeue() {
        assertThrows(RuntimeException.class,() -> R.dequeue());
    }

    @Test
    void isEmpty() {
        assertEquals(true,R.isEmpty());
        R.enqueue(3);
        assertEquals(false,R.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0,R.size());
        R.enqueue(4);
        assertEquals(1,R.size());
        R.dequeue();
        assertEquals(0,R.size());
    }
}