package com.company;

import java.util.*;

/**
 * Created by eugene on 11.02.16.
 */
public class SolutionFinderTree {

    public SolutionFinderTree() {
    }

    public Node find(State start, State target) {
        Node root = new Node(start, null);
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

    public Node findWithHeuristic(State start, State target, AbstractHeuristic heuristic) {
        start.setHeuristic(heuristic);
        Node root = new Node(start, null);
        target.setHeuristic(heuristic);

        LinkedList<Node> openNodes = new LinkedList<>();
        LinkedList<Node> closeNodes = new LinkedList<>();
        openNodes.add(root);

        while (!openNodes.isEmpty()) {
            Node current = (Node) openNodes.poll();

            if (current.getData().equals(target))
                return current;

            closeNodes.add(current);
            List<State> states = current.getData().openState(heuristic);
            for (State state : states) {
                Node child = new Node(state, current);
                if (!closeNodes.contains(child) && !openNodes.contains(child))
                    openNodes.add(child);
                else if (openNodes.contains(child)) {
                    for (Node node : openNodes) {
                        if (node == child && child.fullCost > node.fullCost) {
                            child.fullCost = node.fullCost;
                            break;
                        }
                    }
                }
                else if (closeNodes.contains(child)) {
                    for (Node node : closeNodes) {
                        if (node == child && child.fullCost > node.fullCost) {
                            child.fullCost = node.fullCost;
                            closeNodes.remove(node);
                            openNodes.add(child);
                        }
                    }
                }
            }
            Collections.sort(openNodes);
        }
        return null;
    }
}
