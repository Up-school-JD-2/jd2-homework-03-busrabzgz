package org.example.homeworks.algorithmExamples.palindromCheck;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class PalindromCheck {
    public static boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {

            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



    public static void main(String[] args) {


        System.out.println("=========================================================================");
        System.out.println("Please enter a word as an input to check whether it is palindrome or not!");
        System.out.println("Please If you want to exit, just type exit.");
        System.out.println("=========================================================================");
        ArrayList<String> wordList = new ArrayList<String>();
        while (true) {
            Scanner scanner = new Scanner(in);
            String input = scanner.nextLine();
            String result = null;

            if (isPalindrome(input)) {
                result = input+ " " + "\t is a Palindrome ";
                System.out.println( result);
                wordList.add(result);

            } else if (input.equals("exit")) {
                System.out.println("Logging out and being redirected to your word table!!" +
                        "Check your Desktop to view the table");

                break;

            } else {
                result = input+ "" +"\t is not a Palindrome " +
                        "" +
                        "";
                System.out.println( result);
                wordList.add(result);
            }


        }
        System.out.println(wordList);

    }



}

