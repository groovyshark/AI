package com.company;

import java.util.LinkedList;
import java.util.List;
public class State {
    int[][] area = new int[4][4];

    State(int[][] area) {
        if (area.length != 4 || area[0].length != 4)
            throw new RuntimeException();
        for (int i = 0; i < area.length; i++)
            for (int j = 0; j < area[0].length; j++)
                this.area[i][j] = area[i][j];

    }

    @Override
    public boolean equals(Object _state) {
        State state = (State) _state;
        if (state == this)
            return true;
        for (int i = 0; i < area.length; i++)
            for (int j = 0; j < area[0].length; j++)
                if (area[i][j] != state.area[i][j])
                    return false;
        return true;
    }

    List<State> openState(List closedNodes) {
        List<State> states = new LinkedList<>();
        for (int i = 0; i < area.length - 1; i++) {
            for (int j = 0; j < area.length - 1; j++) {
                State state = new State(area);
                state.swap(i + 1, j, i, j + 1);
                state.swap(i, j, i, j + 1);
                state.swap(i + 1, j, i + 1, j + 1);
                /*if (!this.equals(state))
                    states.add(state);*/
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

    public void print() {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++)
                System.out.print(area[i][j]+ " ");
            System.out.println();
        }
        System.out.println();
    }


}
