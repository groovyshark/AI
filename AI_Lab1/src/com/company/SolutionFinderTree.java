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
            Node current = (Node) openNodes.poll();

            if (current.getData().equals(target))
                return current;

            closeNodes.add(current);
            List<State> states = current.getData().openState();
            for (State state : states) {
                Node child = new Node(state, current);
                if (!openNodes.contains(child) && !closeNodes.contains(child))
                    openNodes.add(child);
            }
        }
        return null;
    }
}
