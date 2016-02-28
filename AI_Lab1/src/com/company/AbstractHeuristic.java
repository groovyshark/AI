package com.company;

/**
 * Created by Eugene on 28.02.2016.
 */
public  abstract class AbstractHeuristic {
    public abstract int getHeuristic(State start, State target);

    int getManhattanDistance(int i1,int j1,int i2,int j2){
        return Math.abs(i1-i2)+Math.abs(j1-j2);
    }
}
