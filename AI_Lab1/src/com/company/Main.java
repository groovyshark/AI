package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int[][] loadAreaFromFile(File file) throws FileNotFoundException {

        int[][] array = new int[4][4];
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++) {
                int tmp = scanner.nextInt();
                array[i][j] = tmp;

            }
        return array;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[][] area = loadAreaFromFile(
                new File("./resources/area.txt"));
        int[][] targetArea = loadAreaFromFile(
                new File("./resources/target.txt"));

        State start = new State(area);
        State target = new State(targetArea);
        //System.out.print(start.equals(start));
        SolutionFinderTree finderTree = new SolutionFinderTree(start);
        SolutionFinderTree.Node result = finderTree.find(target);
        //result.getData().print();
        result.printWay();

    }
}
