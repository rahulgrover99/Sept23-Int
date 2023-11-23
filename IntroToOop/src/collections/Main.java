package collections;

import interfaces.P;

import java.util.*;

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

        Node.NodeIterator nodeIterator = new Node.NodeIterator(head);
        while(nodeIterator.hasNext()) {
            System.out.println(nodeIterator.next());
        }


        LinkedList ll = new LinkedList(head);

        for (Integer i: ll) {
            System.out.println(i);
        }


        List<Node> nodeList = new ArrayList<>(List.of(head.next, head, head.next.next));

        for (Node node: nodeList) {
            System.out.println(node.data);
        }

        Comparator<Node> customComparator = new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                return Integer.compare(t1.data, node.data);
            }
        };

        Collections.sort(nodeList, customComparator);

        for (Node node: nodeList) {
            System.out.println(node.data);
        }

    }
}
