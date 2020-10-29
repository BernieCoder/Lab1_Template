package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.pa.adts.EmptyQueueException;
import pt.pa.adts.FullQueueException;
import pt.pa.adts.Queue;
import pt.pa.adts.QueueLinkedList;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {

    private Queue<Integer> q;
    @BeforeEach
    void setUp(){q= new QueueLinkedList<>();}

    @Test
    void enqueue() throws FullQueueException, EmptyQueueException {
        q.enqueue(1);
        assertEquals(1,q.front());

        for(int i=0;i<9;i++){
            q.enqueue(i);
        }
        assertThrows(FullQueueException.class, () -> {q.enqueue(0);});
    }

    @Test
    void dequeue() throws FullQueueException, EmptyQueueException {
        assertThrows(EmptyQueueException.class, () -> {q.dequeue();});
        q.enqueue(10);
        assertEquals(10, q.dequeue());
    }

    @Test
    void front() throws FullQueueException, EmptyQueueException {
        assertThrows(EmptyQueueException.class, () -> {q.front();});
        q.enqueue(10);
        assertEquals(10, q.front());
    }

    @Test
    void size() throws FullQueueException, EmptyQueueException {
        assertEquals(0,q.size());
        q.enqueue(10);
        assertEquals(1, q.size());
        q.dequeue();
        assertEquals(0,q.size());
    }

    @Test
    void isEmpty() throws FullQueueException {
        assertTrue(q.isEmpty());
        q.enqueue(10);
        assertFalse(q.isEmpty());
    }

    @Test
    void clear() throws FullQueueException {
        q.enqueue(10);
        q.clear();
        assertTrue(q.isEmpty());

    }
}