package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    public static void main(String args[]) {
        part2();
    }

    public static void part1() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day5.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        s = new Scanner("FBFBBFFRLR");

        int highestSeatID = Integer.MIN_VALUE;
        while(s.hasNext()) {
            String ticket = s.next();

            int lowerBound = 0;
            int upperBound = 127;
            int row = -1;
            for(int i = 0; i < 7; i++) {
                if(ticket.charAt(i) == 'F') {
                    upperBound = (upperBound + lowerBound)/2;
                    row = upperBound;
                } else {
                    lowerBound = (int) Math.ceil((double) (upperBound + lowerBound)/2);
                    row = lowerBound;
                }
            }


            lowerBound = 0;
            upperBound = 7;
            int column = -1;
            for(int i = 7; i < 10; i++) {
                if(ticket.charAt(i) == 'L') {
                    upperBound = (upperBound + lowerBound)/2;
                    column = upperBound;
                } else {
                    lowerBound = (int) Math.ceil((double) (upperBound + lowerBound)/2);
                    column = lowerBound;
                }

            }


            int seatID = row * 8 + column;
            if(seatID > highestSeatID) {
                highestSeatID = seatID;
            }
        }
        System.out.println(highestSeatID);
    }

    public static void part2() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day5.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        s = new Scanner("FBFBBFFRLR");

        List<Integer> seatIDs = new ArrayList<Integer>();
        while(s.hasNext()) {
            String ticket = s.next();

            int lowerBound = 0;
            int upperBound = 127;
            int row = -1;
            for(int i = 0; i < 7; i++) {
                if(ticket.charAt(i) == 'F') {
                    upperBound = (upperBound + lowerBound)/2;
                    row = upperBound;
                } else {
                    lowerBound = (int) Math.ceil((double) (upperBound + lowerBound)/2);
                    row = lowerBound;
                }
            }


            lowerBound = 0;
            upperBound = 7;
            int column = -1;
            for(int i = 7; i < 10; i++) {
                if(ticket.charAt(i) == 'L') {
                    upperBound = (upperBound + lowerBound)/2;
                    column = upperBound;
                } else {
                    lowerBound = (int) Math.ceil((double) (upperBound + lowerBound)/2);
                    column = lowerBound;
                }

            }


            int seatID = row * 8 + column;
            seatIDs.add(seatID);
        }

        Collections.sort(seatIDs);

        for(int i = 1; i < seatIDs.size(); i++) {
            if(seatIDs.get(i - 1) == seatIDs.get(i) - 2) {
                System.out.println(seatIDs.get(i) - 1);
            }
        }
    }
}
