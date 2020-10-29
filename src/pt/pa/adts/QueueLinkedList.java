package pt.pa.adts;

/**
 * Provides an implementation of a Queue using a LinkedList
 *
 * @param <T> Is the queue element type.
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;
    private final int capacity=10;

    /**
     * Creates a new QueueLinkedList.
     */
    public QueueLinkedList() {
        this.header=new Node(null,null,null);
        this.trailer= new Node(null,header,null);
        header.next=trailer;
        size=0;
    }

    /**
     * Inserts a new element in the queue.
     * @param elem The element that will be inserted.
     * @throws FullQueueException Will be thrown if the queue is full.
     */
    public void enqueue(T elem) throws FullQueueException{
        if(size()>=capacity) throw new FullQueueException();

        Node node= new Node(elem,trailer.prev,trailer);
        trailer.prev.next=node;
        trailer.prev=node;
        size++;
    }

    /**
     * Removes the last element in the queue, according to FIFO order.
     * @return The last element in the queue.
     * @throws EmptyQueueException Will be thrown if the queue is empty.
     */
    public T dequeue() throws EmptyQueueException{
        if(isEmpty()) throw new EmptyQueueException();

        Node node= header.next;
        header.next=node.next;
        node.prev=header;
        size--;
        return node.element;
    }

    /**
     * Returns the last element in the queue, according to FIFO order.
     * @return The last element in the queue.
     * @throws EmptyQueueException Will be thrown if the queue is empty.
     */
    public T front() throws EmptyQueueException{
        if(isEmpty()) throw new EmptyQueueException();
        return header.next.element;
    }

    /**
     * Returns the number of elements in the queue.
     * @return The queue size.
     */
    public int size(){
        return size;
    }

    /**
     * Checks if the queue does not have elements.
     * @return true if empty, false if not.
     */
    public boolean isEmpty(){
        return header.next == trailer;
    }

    /**
     * Removes all elements from the queue.
     */
    public void clear(){
        header.next=trailer;
        trailer.prev=header;
        size=0;
    }


    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}



