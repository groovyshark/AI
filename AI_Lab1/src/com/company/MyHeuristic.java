package com.company;

/**
 * Created by Eugene on 28.02.2016.
 */
public class MyHeuristic extends AbstractHeuristic {
    @Override
    public int getHeuristic(State start, State target) {
        int count = 0;
        for (int i = 0; i < start.area[0].length; i += 2) {
            for (int j = 0; j < start.area.length; j += 2) {
                if (start.area[i][j] == target.area[i][j] &&
                        start.area[i + 1][j] == target.area[i + 1][j] &&
                        start.area[i][j + 1] == target.area[i][j + 1] &&
                        start.area[i + 1][j + 1] == target.area[i + 1][j + 1]) continue;
                else
                    count++;
            }
        }
        return count;
    }
}
