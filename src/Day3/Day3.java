package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {
    public static void main(String args[]) {
        part2();
    }

    public static void part1() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> rows = new ArrayList<String>();

        while(s.hasNextLine()) {
            rows.add(s.nextLine());
        }

        int numberOfTrees = 0;

        int row = 0;
        int col = 0;
        do {
            if(rows.get(row).substring(col, col + 1).equals("#")) {
                numberOfTrees++;
            }

            col = (col + 3) % rows.get(row).length();
            row++;
        } while (row < rows.size());

        System.out.println(numberOfTrees);
    }

    public static void part2() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> rows = new ArrayList<String>();

        while(s.hasNextLine()) {
            rows.add(s.nextLine());
        }

        long output = 1;
        output *= slope(1, 1, rows);
        output *= slope(1, 3, rows);
        output *= slope(1, 5, rows);
        output *= slope(1, 7, rows);
        output *= slope(2, 1, rows);
        System.out.println(output);
    }

    public static int slope(int down, int across, ArrayList<String> rows) {
        int numberOfTrees = 0;

        int row = 0;
        int col = 0;
        do {
            if(rows.get(row).substring(col, col + 1).equals("#")) {
                numberOfTrees++;
            }

            col = (col + across) % rows.get(row).length();
            row += down;
        } while (row < rows.size());

        return numberOfTrees;
    }
}
