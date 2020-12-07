package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day6 {

    public static void main (String args[]) {
        part2();
    }

    public static void part1() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day6.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashSet<Character> questionsAnswered  = new HashSet<Character>();
        int numberOfQuestionsAnswered = 0;

        while(s.hasNextLine()) {
            String line = s.nextLine();
            if(line.equals("")) {
                numberOfQuestionsAnswered += questionsAnswered.size();
                questionsAnswered = new HashSet<Character>();
            } else {
                for(int i = 0; i < line.length(); i++) {
                    questionsAnswered.add(line.charAt(i));
                }
            }
        }
        numberOfQuestionsAnswered += questionsAnswered.size();
        System.out.println(numberOfQuestionsAnswered);
    }

    public static void part2() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day6.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<Character, Integer> questionsAnswered  = new HashMap<Character, Integer>();
        int numberOfQuestionsAnswered = 0;
        int numberOfGroupMembers = 0;
        while(s.hasNextLine()) {
            String line = s.nextLine();
            if(line.equals("")) {
                int numberOfQuestionsAnsweredGroup = 0;

                for(Character c : questionsAnswered.keySet())
                    if(questionsAnswered.get(c) == numberOfGroupMembers)
                        numberOfQuestionsAnsweredGroup++;

                numberOfQuestionsAnswered += numberOfQuestionsAnsweredGroup;
                numberOfGroupMembers = 0;
                questionsAnswered = new HashMap<Character, Integer>();
            } else {
                numberOfGroupMembers++;
                for(int i = 0; i < line.length(); i++) {
                    if(questionsAnswered.containsKey(line.charAt(i)))
                        questionsAnswered.put(line.charAt(i), questionsAnswered.get(line.charAt(i)) + 1);
                    else
                        questionsAnswered.put(line.charAt(i), 1);
                }
            }
        }
        int numberOfQuestionsAnsweredGroup = 0;

        for(Character c : questionsAnswered.keySet())
            if(questionsAnswered.get(c) == numberOfGroupMembers)
                numberOfQuestionsAnsweredGroup++;

        numberOfQuestionsAnswered += numberOfQuestionsAnsweredGroup;
        System.out.println(numberOfQuestionsAnswered);
    }
}
