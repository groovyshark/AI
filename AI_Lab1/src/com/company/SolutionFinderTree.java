package com.company;

import java.util.*;

/**
 * Created by eugene on 11.02.16.
 */
public class SolutionFinderTree {
    private Node root;

    public SolutionFinderTree(State rootData) {
        root = new Node(rootData, null);
        root.children = new LinkedList<Node>();
    }

    public Node find(State target) {
        Queue openNodes = new LinkedList<Node>();
        List<Node> closeNodes = new ArrayList<>();
        openNodes.add(root);

        while (!openNodes.isEmpty()) {
            //System.out.println("i");
            Node temp = (Node) openNodes.poll();

            if (temp.data.equals(target))
                return temp;
            if (closeNodes.contains(temp))
                continue;

            closeNodes.add(temp);
            List<State> states = temp.data.openState();

            if (!states.isEmpty()) {
                Iterator iterator = states.iterator();
                Node child;
                while (iterator.hasNext()) {
                    child = new Node((State) iterator.next(), temp);
                    if (child.data.equals(target))
                        return child;
                    //temp.children.add(child);
                    openNodes.add(child);
                }
            }
        }

        return null;
    }

    public class Node {
        private State data;
        private Node parent;
        private List<Node> children;

        public State getData() {
            return data;
        }

        public Node(State data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

        public void printWay() {
            Node current = this;
            while (current != null) {
                current.data.print();
                current = current.parent;
            }
        }
    }
}
