package com.company;

import java.util.LinkedList;
import java.util.List;
public class State {
    int[][] area;

    public State(int[][] area) {
        if (area.length < 2 || area[0].length <2)
            throw new RuntimeException();
        this.area = new int[area.length][area[0].length];
        for (int i = 0; i < area.length; i++)
            for (int j = 0; j < area[0].length; j++)
                this.area[i][j] = area[i][j];

    }

    @Override
    public boolean equals(Object object) {
        State state = (State) object;
        if (state == this)
            return true;
        for (int i = 0; i < area.length; i++)
            for (int j = 0; j < area[0].length; j++)
                if (area[i][j] != state.area[i][j])
                    return false;
        return true;
    }

    List openState(List closedNodes) {
        List<State> states = new LinkedList<>();
        for (int i = 0; i < area.length - 1; i++) {
            for (int j = 0; j < area[0].length - 1; j++) {
                State state = new State(area);
                state.swap(i + 1, j, i, j + 1);
                state.swap(i, j, i, j + 1);
                state.swap(i + 1, j, i + 1, j + 1);
                if(!closedNodes.contains(new Node(state,null)))
                    states.add(state);
            }
        }
        return states;
    }

    private void swap(int i1, int j1, int i2, int j2) {
        int temp = area[i1][j1];
        area[i1][j1] = area[i2][j2];
        area[i2][j2] = temp;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++)
                builder.append(area[i][j]+ " ");
            builder.append("\n");
        }
        return builder.toString();
    }


}
