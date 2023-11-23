package collections;

import interfaces.P;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        // Iterating using iterator.
        Iterator<Integer> listIterator = list.iterator();

        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // Enhanced for loop - internals are the same.
        for (Integer integer : list) {
            System.out.println(integer);
        }

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        NodeIterator nodeIterator = new NodeIterator(head);
        while(nodeIterator.hasNext()) {
            System.out.println(nodeIterator.next());
        }

        LinkedList ll = new LinkedList(head);

        for (Integer i: ll) {
            System.out.println(i);
        }

    }
}
