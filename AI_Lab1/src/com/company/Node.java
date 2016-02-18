package com.company;

import java.util.List;
import java.util.Stack;

public class Node {
    private State data;
    private Node parent;
    List<Node> children;

    public State getData() {
        return data;
    }

    public Node(State data, Node parent) {
        this.data = data;
        this.parent = parent;
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
}