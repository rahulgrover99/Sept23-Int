package collections;

import java.util.Iterator;

public class Node implements Comparable<Node> {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.data, node.data);
    }

    static class NodeIterator implements Iterator<Integer> {

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
}
