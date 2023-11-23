package collections;

import java.util.Iterator;

public class LinkedList implements Iterable<Integer>{

    private Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator(head);
    }
}
