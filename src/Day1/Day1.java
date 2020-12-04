package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day1 {

    public static void main (String args[]) {
        part2();
    }

    public static void part1() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashSet<Integer> ints = new HashSet<Integer>();
        while(s.hasNextInt()) {
            ints.add(s.nextInt());
        }

        for(int number : ints) {
            if(ints.contains(2020 - number)) {
                System.out.println( number * (2020 - number) );
                return;
            }
        }
    }

    public static void part2() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashSet<Integer> ints = new HashSet<Integer>();
        while(s.hasNextInt()) {
            ints.add(s.nextInt());
        }

        for(int number1 : ints) {
            for(int number2 : ints) {
                if (ints.contains(2020 - (number1 + number2))) {
                    System.out.println(number1 * number2 * (2020 - (number1 + number2)));
                    return;
                }
            }
        }
    }

}
