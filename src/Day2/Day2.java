package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day2 {

    public static void main (String args[]) {
        part2();
    }

    public static void part1() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfValidPasswords = 0;

        while(s.hasNext()) {
            String bounds = s.next();
            int lowerBound = Integer.parseInt(bounds.substring(0, bounds.indexOf("-")));
            int upperBound = Integer.parseInt(bounds.substring(bounds.indexOf("-") + 1));
            String character = s.next().substring(0, 1);
            String password = s.next();

            int instancesOfCharacter = 0;

            for(int i = 0; i < password.length(); i++) {
                if(password.substring(i, i + 1).equals(character)) {
                    instancesOfCharacter++;
                }
            }

            if(instancesOfCharacter >= lowerBound && instancesOfCharacter <= upperBound) {
                numberOfValidPasswords++;
            }

        }


        System.out.println(numberOfValidPasswords);
    }

    public static void part2() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfValidPasswords = 0;

        while(s.hasNext()) {
            String bounds = s.next();
            int include = Integer.parseInt(bounds.substring(0, bounds.indexOf("-")));
            int exclude = Integer.parseInt(bounds.substring(bounds.indexOf("-") + 1));
            String character = s.next().substring(0, 1);
            String password = s.next();


            if(password.substring(include - 1, include).equals(character)) {
                if (!password.substring(exclude - 1, exclude).equals(character)) {
                    numberOfValidPasswords++;
                }
            } else if(password.substring(exclude - 1, exclude).equals(character)) {
                if (!password.substring(include - 1, include).equals(character)) {
                    numberOfValidPasswords++;
                }
            }



        }


        System.out.println(numberOfValidPasswords);
    }

}
