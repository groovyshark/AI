package com.company;

/**
 * Created by Eugene on 28.02.2016.
 */
public class StupidHeuristic extends AbstractHeuristic {
    public int getHeuristic(State start, State target) {
        int count = 0;
        for (int i = 0; i < start.area[0].length; i++)
            for (int j = 0; j < start.area.length; j++) {
                if (start.area[i][j] == 1 && target.area[i][j] == 0)
                    count++;
            }
        return count;
    }
}
