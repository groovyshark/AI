package com.company;

import java.util.List;
import java.util.Stack;

public class Node implements Comparable<Node> {
    private State data;
    private Node parent;
    List<Node> children;
    int fullCost = 0;

    public State getData() {
        return data;
    }

    public Node(State data, Node parent) {
        this.data = data;
        this.parent = parent;
        fullCost = data.getHeuristic();
        if(this.parent!= null)
            fullCost++;
    }

    public Stack<Node> printWay() {
        Stack<Node> stack = new Stack<>();
        Node current = this;

        while (current != null) {
            stack.add(current);
            //System.out.println(current.data.toString());
            current = current.parent;
        }
        return stack;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        else if (this.getData().equals(((Node) object).getData()))
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Node o) {
        if (this.fullCost < o.fullCost) return -1;
        else if (this.fullCost > o.fullCost) return 1;
        else return 0;
    }
}