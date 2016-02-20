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
            Node temp = (Node) openNodes.poll();

            if (temp.getData().equals(target))
                return temp;

            closeNodes.add(temp);
            List<State> states = temp.getData().openState();

            if (!states.isEmpty()) {
                Iterator iterator = states.iterator();
                Node child;
                while (iterator.hasNext()) {
                    child = new Node((State) iterator.next(), temp);
                    if (!openNodes.contains(child) && !closeNodes.contains(child))
                        openNodes.add(child);
                }
            }
        }

        return null;
    }
}
