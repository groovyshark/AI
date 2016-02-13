package com.company;

import java.util.List;

/**
 * Created by eugene on 11.02.16.
 */
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

    public void printWay() {
        Node current = this;
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.parent;
        }
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