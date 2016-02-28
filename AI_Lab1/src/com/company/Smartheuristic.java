package com.company;

/**
 * Created by Eugene on 28.02.2016.
 */
public class SmartHeuristic extends AbstractHeuristic {
    @Override
    public int getHeuristic(State start, State target) {
        int count = 0;
        int manhattanDistance = 0;
        for (int i = 0; i < start.area[0].length; i++) {
            for (int j = 0; j < start.area.length; j++) {
                if (target.area[i][j] == 1 && start.area[i][j] == 0) {
                    manhattanDistance = 50000;
                    for (int k = 0; k < start.area[0].length; k++)
                        for (int m = 0; m < start.area.length; m++) {
                            if (target.area[k][m] == 0 && start.area[k][m] == 1 && manhattanDistance > getManhattanDistance(i, j, k, m)) {
                                manhattanDistance = getManhattanDistance(i, j, k, m);
                            }
                        }
                }
                count += manhattanDistance;
            }
        }
        return count;
    }
}
