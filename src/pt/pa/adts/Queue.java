package pt.pa.adts;

/**
 * Defines a queue abstract data type.
 *
 * @param <T> Is the queue element type.
 */
public interface Queue<T> {
    /**
     * Inserts a new element in the queue.
     * @param elem The element that will be inserted.
     * @throws FullQueueException Will be thrown if the queue is full.
     */
    public void enqueue(T elem) throws FullQueueException;

    /**
     * Removes the last element in the queue, according to FIFO order.
     * @return The last element in the queue.
     * @throws EmptyQueueException Will be thrown if the queue is empty.
     */
    public T dequeue()throws EmptyQueueException;

    /**
     * Returns the last element in the queue, according to FIFO order.
     * @return The last element in the queue.
     * @throws EmptyQueueException Will be thrown if the queue is empty.
     */
    public T front()throws EmptyQueueException;

    /**
     * Returns the number of elements in the queue.
     * @return The queue size.
     */
    public int size();

    /**
     * Checks if the queue does not have elements.
     * @return true if empty, false if not.
     */
    public boolean isEmpty();

    /**
     * Removes all elements from the queue.
     */
    public void clear();

}
