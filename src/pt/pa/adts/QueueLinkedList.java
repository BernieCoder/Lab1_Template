package pt.pa.adts;

/**
 * TODO: Fornecer documentação da classe.
 *
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;

    public QueueLinkedList() {
        //TODO: construtor deve inicializar uma fila vazia
        this.header=new Node(null,null,trailer);
        this.trailer= new Node(null,header,null);
        size=0;
    }
    /*
     *
     * */
    public void enqueue(T elem) throws FullQueueException{
        Node node= new Node(elem,trailer.prev,trailer);

    }
    public T dequeue() throws EmptyQueueException{
        if(isEmpty())throw new EmptyQueueException();
        Node node= header.next;
        header.next=node.next;
        node.prev=header;
        return node.element;
    }
    public T front() throws EmptyQueueException{
        if(isEmpty()) throw new EmptyQueueException;
        return header.next.element;
    }

    public int size(){
        Node node = header.next;
        while(node!=trailer){
            node=node.next;
            size++;
        }
        return size;
    }
    public boolean isEmpty(){
        if(header.next==trailer)return true;
        else return false;
    }
    public void clear(){
        Node node = header.next;
        while(node!=trailer){
            node=node.next;

        }
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida

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



