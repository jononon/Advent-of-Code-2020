package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day4 {
    public static void main(String args[]) {
        part2();
    }

    public static void part1() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day4.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfValidPassports = 0;
        HashSet<String> fieldsOfCurrrentPassport = new HashSet<String>();
        while (s.hasNextLine()) {
            String nextLine = s.nextLine();

            Scanner i = new Scanner(nextLine);
            while(i.hasNext()) {
                String fieldData = i.next();
                fieldsOfCurrrentPassport.add(fieldData.substring(0, fieldData.indexOf(":")));
            }

            if(nextLine.equals("")) {
                if(fieldsOfCurrrentPassport.contains("byr") &&
                    fieldsOfCurrrentPassport.contains("iyr") &&
                    fieldsOfCurrrentPassport.contains("eyr") &&
                    fieldsOfCurrrentPassport.contains("hgt") &&
                    fieldsOfCurrrentPassport.contains("hcl") &&
                    fieldsOfCurrrentPassport.contains("ecl") &&
//                    fieldsOfCurrrentPassport.contains("cid") &&
                    fieldsOfCurrrentPassport.contains("pid")
                    ) {
                    numberOfValidPassports++;
                }
                fieldsOfCurrrentPassport = new HashSet<String>();
            }
        }

        System.out.println(numberOfValidPassports);
    }

    public static void part2() {
        Scanner s = null;

        try {
            s = new Scanner(new File("inputs/day4.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfValidPassports = 0;
        HashMap<String, String> fieldsOfCurrrentPassport = new HashMap<String, String>();
        while (s.hasNextLine()) {
            String nextLine = s.nextLine();

            Scanner i = new Scanner(nextLine);
            while(i.hasNext()) {
                String fieldData = i.next();
                fieldsOfCurrrentPassport.put(fieldData.substring(0, fieldData.indexOf(":")), fieldData.substring(fieldData.indexOf(":") + 1));
            }

            if(nextLine.equals("")) {
                boolean isValidPassport = true;
                if(!(fieldsOfCurrrentPassport.containsKey("byr") &&
                        fieldsOfCurrrentPassport.containsKey("iyr") &&
                        fieldsOfCurrrentPassport.containsKey("eyr") &&
                        fieldsOfCurrrentPassport.containsKey("hgt") &&
                        fieldsOfCurrrentPassport.containsKey("hcl") &&
                        fieldsOfCurrrentPassport.containsKey("ecl") &&
//                    fieldsOfCurrrentPassport.contains("cid") &&
                        fieldsOfCurrrentPassport.containsKey("pid")
                )) {
                    isValidPassport = false;
                } else {

                    if (fieldsOfCurrrentPassport.get("byr").length() != 4)
                        isValidPassport = false;
                    if (Integer.parseInt(fieldsOfCurrrentPassport.get("byr")) < 1920)
                        isValidPassport = false;
                    if (Integer.parseInt(fieldsOfCurrrentPassport.get("byr")) > 2002)
                        isValidPassport = false;

                    if (fieldsOfCurrrentPassport.get("iyr").length() != 4)
                        isValidPassport = false;
                    if (Integer.parseInt(fieldsOfCurrrentPassport.get("iyr")) < 2010)
                        isValidPassport = false;
                    if (Integer.parseInt(fieldsOfCurrrentPassport.get("iyr")) > 2020)
                        isValidPassport = false;

                    if (fieldsOfCurrrentPassport.get("eyr").length() != 4)
                        isValidPassport = false;
                    if (Integer.parseInt(fieldsOfCurrrentPassport.get("eyr")) < 2020)
                        isValidPassport = false;
                    if (Integer.parseInt(fieldsOfCurrrentPassport.get("eyr")) > 2030)
                        isValidPassport = false;


                    if (fieldsOfCurrrentPassport.get("hgt").contains("in")) {
                        String field = fieldsOfCurrrentPassport.get("hgt");
                        int height = Integer.parseInt(field.substring(0, field.indexOf("in")));
                        if (height < 59 || height > 76)
                            isValidPassport = false;
                    } else if (fieldsOfCurrrentPassport.get("hgt").contains("cm")) {
                        String field = fieldsOfCurrrentPassport.get("hgt");
                        int height = Integer.parseInt(field.substring(0, field.indexOf("cm")));
                        if (height < 150 || height > 193)
                            isValidPassport = false;
                    } else {
                        isValidPassport = false;
                    }

                    String hclField = fieldsOfCurrrentPassport.get("hcl");
                    if (hclField.length() != 7) {
                        isValidPassport = false;
                    } else if (!hclField.substring(0, 1).equals("#")) {
                        isValidPassport = false;
                    } else {
                        for (int q = 1; q < hclField.length(); q++) {
                            if (!((hclField.charAt(q) <= '9' && hclField.charAt(q) >= '0') || (hclField.charAt(q) <= 'f' && hclField.charAt(q) >= 'a'))) {
                                isValidPassport = false;
                            }
                        }
                    }

                    if (!("amb blu brn gry grn hzl oth".contains(fieldsOfCurrrentPassport.get("ecl"))))
                        isValidPassport = false;

                    if (fieldsOfCurrrentPassport.get("pid").length() != 9) {
                        isValidPassport = false;
                    } else {
                        for (int q = 0; q < fieldsOfCurrrentPassport.get("pid").length(); q++) {
                            if (fieldsOfCurrrentPassport.get("pid").charAt(q) < '0' || fieldsOfCurrrentPassport.get("pid").charAt(q) > '9') {
                                isValidPassport = false;
                            }
                        }
                    }
                }

                if(isValidPassport) {
                    numberOfValidPassports++;
                }

                fieldsOfCurrrentPassport = new HashMap<String, String>();
            }
        }

        System.out.println(numberOfValidPassports);
    }
}
