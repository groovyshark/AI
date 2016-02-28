package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int[][] loadAreaFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] array = new int[rows][columns];

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++) {
                int tmp = scanner.nextInt();
                array[i][j] = tmp;

            }
        return array;
    }

    public static void main(String[] args) throws IOException {
        int[][] area = loadAreaFromFile(
                new File("./resources/area.txt"));
        int[][] targetArea = loadAreaFromFile(
                new File("./resources/target.txt"));

        State target = new State(targetArea,null);
        State start = new State(area,target);

        SolutionFinderTree finderTree = new SolutionFinderTree();
        long startTime = System.currentTimeMillis();
        //Node result = finderTree.find(start,target);
        Node result = finderTree.findWithHeuristic(start,target,new SmartHeuristic());
        long endTime = System.currentTimeMillis();
        if(result==null) {
            System.out.println("Решение не найдено!");
            return;
        }
        System.out.println("Решение найдено!\nВремя нахождения решения(мс): "+ (double)(endTime-startTime)+"\n");
        Stack<Node> stack = result.printWay();
        FileWriter writer =  new FileWriter("./resources/solution.txt");
        while (!stack.empty()) {
            writer.append(stack.pop().getData().toString());
            writer.append("\n");
        }
        writer.close();
        System.out.println("Подробности решения в файле Solution.txt");

    }
}
