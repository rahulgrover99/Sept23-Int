package collections;

import java.util.Iterator;

class NodeIterator implements Iterator<Integer> {

    public NodeIterator(Node curr) {
        this.curr = curr;
    }

    private Node curr;

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public Integer next() {
        Node toReturn = curr;
        curr = curr.next;
        return toReturn.data;
    }
}