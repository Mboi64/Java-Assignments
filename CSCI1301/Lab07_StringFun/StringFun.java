/*
 * StringFun.java 
 * Author: Cedric Amponsem 
 * Submission Date: 3/20/26
 *
 * Purpose: The user is able to input a string character, word, or sentence into
 * the program. The program will allow the user to choose between 6 different
 * commands that can modify their text such as reversing the text, replacing the
 * first or last instance of a specific character, removing a singular or a
 * group of characters, and (when done with the program) quit the program.
 */

import java.util.Scanner;

public class StringFun {
    public static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        String userInput, userCommand, charReplace, newChar, charChoice;
        int number;

        System.out.println("Enter the string to be manipulated");
        userInput = INPUT.nextLine();

        while (userInput.length() > 0) {
            System.out.println(
                "Enter your command (reverse, replace first, replace last, remove all, remove, quit)");
            userCommand = INPUT.nextLine();

            if (userCommand.equalsIgnoreCase("reverse")) { // REVERSE COMMAND
                System.out.print("The new sentence is: ");
                userInput = StringFun.getReverse(userInput);
                System.out.println(userInput);

            } else if (userCommand.equalsIgnoreCase("replace first")) { // REPLACE FIRST COMMAND
                System.out.println("Enter the character to replace");
                charReplace = INPUT.nextLine();
                System.out.println("Enter the new character");
                newChar = INPUT.nextLine();

                // Checks if the letter is exist
                if (StringFun.replaceFirstChar(userInput, charReplace, newChar).equals(userInput)) {
                    System.out.println("The letter was not found in the word");
                } else {
                    System.out.print("The new sentence is: ");
                    userInput = StringFun.replaceFirstChar(userInput, charReplace, newChar);
                    System.out.println(userInput);
                }

            } else if (userCommand.equalsIgnoreCase("replace last")) { // REPLACE LAST COMMAND
                System.out.println("Enter the character to replace");
                charReplace = INPUT.nextLine();
                System.out.println("Enter the new character");
                newChar = INPUT.nextLine();

                // Checks if the letter is exist
                if (StringFun.replaceLastChar(userInput, charReplace, newChar).equals(userInput)) {
                    System.out.println("The letter was not found in the word");
                } else {
                    System.out.print("The new sentence is: ");
                    userInput = StringFun.replaceLastChar(userInput, charReplace, newChar);
                    System.out.println(userInput);
                }

            } else if (userCommand.equalsIgnoreCase("remove all")) { // REMOVE ALL COMMAND
                System.out.println("Enter the character to remove");
                charChoice = INPUT.nextLine();

                // Checks if the letter exist
                if (StringFun.removeAll(userInput, charChoice).equals(userInput)) {
                    System.out.println("Error: the letter you are trying to remove does not exist");
                } else {
                    System.out.print("The new sentence is: ");
                    userInput = StringFun.removeAll(userInput, charChoice);
                    System.out.println(userInput);
                }

            } else if (userCommand.equalsIgnoreCase("remove")) { // REMOVE COMMAND

                System.out.println("Enter the character to remove");
                charChoice = INPUT.nextLine();

                System.out.println("Enter the " + charChoice
                    + " you would like to remove (Not the index - 1 = 1st, 2 = 2nd, etc.):");
                number = INPUT.nextInt();
                INPUT.nextLine(); // helps to remove the empty string from the number value

                // Checks if the number input is accurate to the amount of times the character
                // exist
                if (StringFun.removeChar(userInput, charChoice, number) == null) {
                    System.out.println("Error: the letter you are trying to remove does not exist");
                } else {
                    System.out.print("The new sentence is: ");
                    userInput = StringFun.removeChar(userInput, charChoice, number);
                    System.out.println(userInput);
                }

            } else if (userCommand.equalsIgnoreCase("quit")) { // QUIT COMMAND
                StringFun.quitCommand(userCommand);

            } else { // INVAID INPUT
                System.out.println("Command invalid. Try again");
            }

        }
    } // main

    public static String getReverse(String userInput) {
        String reverse = "";

        for (int i = userInput.length() - 1; i >= 0; i--) {
            reverse += userInput.charAt(i);
        }
        return reverse;

    } // getReverse

    public static String replaceFirstChar(String userInput, String charReplace, String newChar) {
        String replaced = "";
        boolean happenedOnce = true;

        for (int i = 0; i < userInput.length(); i++) {
            String letter = "" + userInput.charAt(i);
            if (letter.equals(charReplace) && happenedOnce) {
                replaced += newChar;
                happenedOnce = false;
            } else {
                replaced += userInput.charAt(i);
            }
        }

        return replaced;
    } // replaceFirstChar

    public static String replaceLastChar(String userInput, String charReplace, String newChar) {
        String replaced = "";
        int lastIndex = -1;

        // Checks which character to change by its index
        for (int i = 0; i < userInput.length(); i++) {
            String charSetUp = "" + userInput.charAt(i);
            if (charSetUp.equals(charReplace)) {
                lastIndex = i;
            }
        }

        // Print with replacement
        for (int i = 0; i < userInput.length(); i++) {
            if (i == lastIndex) {
                replaced += newChar;
            } else {
                replaced += userInput.charAt(i);
            }
        }

        return replaced;
    } // replaceLastChar

    public static String removeAll(String userInput, String charChoice) {
        String removeAll = "";

        for (int i = 0; i < userInput.length(); i++) {
            String charSetup = "" + userInput.charAt(i);
            if (charSetup.equals(charChoice)) {
                removeAll += "";
            } else {
                removeAll += userInput.charAt(i);
            }
        }

        return removeAll;
    } // removeAll

    public static String removeChar(String userInput, String charChoice, int number) {
        String removeChar = "";
        int numberOfTimes = 0;

        // Checks to see how many times the character appears
        for (int i = 0; i < userInput.length(); i++) {
            String charSetup = "" + userInput.charAt(i);
            if (charSetup.equals(charChoice)) {
                numberOfTimes += 1;
            }
        }

        // Remove the placement of which that character appears depending on number
        if (numberOfTimes < number || number < 0) {
            removeChar = null;
        } else {
            numberOfTimes = 0; // resets the numberOfTimes
            for (int i = 0; i < userInput.length(); i++) {
                String charSetup = "" + userInput.charAt(i);
                if (charSetup.equals(charChoice)) {
                    numberOfTimes += 1;
                    if ((numberOfTimes == number)) {
                        removeChar += "";
                    } else {
                        removeChar += userInput.charAt(i);
                    }
                } else {
                    removeChar += userInput.charAt(i);
                }
            }
        }

        return removeChar;
    } // removeIndex

    public static void quitCommand(String userCommand) {
        if (userCommand.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
    } // quitCommand
}
