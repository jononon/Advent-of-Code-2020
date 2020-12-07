package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) {
        part2();
    }

    public static void part1() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day7.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<String, HashMap<String, Integer>> allBags = new HashMap<String, HashMap<String, Integer>>();

        while(s.hasNextLine()) {
            String line = s.nextLine();
            String bagName = line.substring(0, line.indexOf("bags") - 1);
            allBags.put(bagName, new HashMap<String, Integer>());

            line = line.substring(line.indexOf("bags contain") + "bags contain".length() + 1, line.length() - 1);
            String[] childrenArr = line.split(", ");
            for(String bag : childrenArr) {
                if(!bag.equals("no other bags")) {
                    int quantity = Integer.parseInt(bag.substring(0, bag.indexOf(" ")));
                    String childBagName = bag.substring(bag.indexOf(" ") + 1, bag.indexOf("bag") - 1);
                    allBags.get(bagName).put(childBagName, quantity);
                }
            }
        }

        int numberOfBagColours = 0;

        for(String bagName : allBags.keySet()) {
            if(doesContainShinyGoldBag(allBags, bagName)) {
                numberOfBagColours++;
            }
        }

        System.out.println(numberOfBagColours);

    }

    public static boolean doesContainShinyGoldBag (HashMap<String, HashMap<String, Integer>> allBags, String bag) {
        if(allBags.get(bag).containsKey("shiny gold")) {
            return true;
        }
        for(String childBag : allBags.get(bag).keySet()) {
            if(doesContainShinyGoldBag(allBags, childBag)) {
                return true;
            }
        }
        return false;
    }

    public static void part2() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day7.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<String, HashMap<String, Integer>> allBags = new HashMap<String, HashMap<String, Integer>>();

        while(s.hasNextLine()) {
            String line = s.nextLine();
            String bagName = line.substring(0, line.indexOf("bags") - 1);
            allBags.put(bagName, new HashMap<String, Integer>());

            line = line.substring(line.indexOf("bags contain") + "bags contain".length() + 1, line.length() - 1);
            String[] childrenArr = line.split(", ");
            for(String bag : childrenArr) {
                if(!bag.equals("no other bags")) {
                    int quantity = Integer.parseInt(bag.substring(0, bag.indexOf(" ")));
                    String childBagName = bag.substring(bag.indexOf(" ") + 1, bag.indexOf("bag") - 1);
                    allBags.get(bagName).put(childBagName, quantity);
                }
            }
        }

        System.out.println(bagsContainedRecursive(allBags, "shiny gold"));

    }

    public static int bagsContainedRecursive (HashMap<String, HashMap<String, Integer>> allBags, String bag) {
        int bagCount = 0;
        HashMap<String, Integer> childBags = allBags.get(bag);
        for(String childBag : childBags.keySet()) {
            bagCount += bagsContainedRecursive(allBags, childBag) * childBags.get(childBag) + childBags.get(childBag);
        }
        return bagCount;
    }
}
