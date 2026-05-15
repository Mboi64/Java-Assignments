/*
 * GradeCalculator.java 
 * Author: Cedric Amponsem 
 * Submission Date: 2/27/2026
 *
 * Purpose: The program allows the user to see if their current average grade is
 * what up to their desired grade letter. The user will submit their desire
 * grade and the weight of their performance (Exam 1, Exam 2, Final Exam, Labs,
 * Quizzes, Projects, and Participation), and the program will calculate:
 * whether the achieve their desired score, whether it is impossible to achieve
 * the score, whether their score is already achieved, or determine how many
 * pointed need to achieve their desired letter grade.
 */
import java.util.Scanner;

public class GradeCalculator {
    public static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {

        String letterGrade;

        // Displays Grading Scale
        System.out.print("Grading Scale:\r\n" + "A\t 90 - 100\r\n" + "B\t 80 - 89\r\n"
            + "C\t 70 - 79\r\n" + "D\t 60 - 69\r\n" + "F\t below 60\r\n" + "");

        // Checks for correct inputs
        System.out.print("What letter grade do you want to achieve for the course?");
        letterGrade = INPUT.next();
        if (!(letterGrade.equalsIgnoreCase("a")) && !(letterGrade.equalsIgnoreCase("b"))
            && !(letterGrade.equalsIgnoreCase("c")) && !(letterGrade.equalsIgnoreCase("d"))
            && !(letterGrade.equalsIgnoreCase("f"))) {
            System.out.print("The input is invalid.");
            System.exit(0);
        }

        // Asks for the weight of each item
        System.out.println("Enter percentage weights below.");
        System.out.printf("Exam 1: \t");
        double examWeight1 = INPUT.nextInt();

        System.out.printf("Exam 2: \t");
        double examWeight2 = INPUT.nextInt();

        System.out.printf("Final Exam: \t");
        double finalExamWeight = INPUT.nextInt();

        System.out.printf("Labs:   \t");
        double labWeight = INPUT.nextInt();

        System.out.printf("Projects: \t");
        double projectWeight = INPUT.nextInt();

        System.out.printf("Participation: \t");
        double participationWeight = INPUT.nextInt();

        System.out.printf("Quizzes: \t");
        double quizWeight = INPUT.nextInt();

        // Calculates is grade weight is usable
        double totalGradeWeight = examWeight1 + examWeight2 + finalExamWeight + labWeight
            + projectWeight + participationWeight + quizWeight;

        if (totalGradeWeight != 100) {
            System.out.print("Weights don't add up to 100, program exiting...");
            System.exit(0);
        }

        // Exam Weight and Scores
        double currentKnownGradeWeight = 0;
        double weightScoreOfExam1 = 0;
        double weightScoreOfExam2 = 0;
        double weightScoreOfFinalExam = 0;

        // Checks if the user input a "yes" for the exams
        System.out.print("Do you know your exam 1 score?");
        String studentInput = INPUT.next();
        boolean confirmation = studentInput.equalsIgnoreCase("y")
            || studentInput.equalsIgnoreCase("yes");
        if (confirmation) {
            System.out.print("Score received on exam 1:");
            double examScore1 = INPUT.nextDouble();
            weightScoreOfExam1 = examWeight1 * examScore1;
            // The weighted item is added if the user agrees to having an average score
            if (confirmation) {
                currentKnownGradeWeight += examWeight1;
            }

            System.out.print("Do you know your exam 2 score?");
            studentInput = INPUT.next();
            confirmation = studentInput.equalsIgnoreCase("y")
            || studentInput.equalsIgnoreCase("yes");
            if (confirmation) {
                System.out.print("Score received on exam 2:");
                double examScore2 = INPUT.nextDouble();
                weightScoreOfExam2 = examWeight2 * examScore2;
                if (confirmation) {
                    currentKnownGradeWeight += examWeight2;
                }

                System.out.print("Do you know your final exam score?");
                studentInput = INPUT.next();
                confirmation = studentInput.equalsIgnoreCase("y")
                || studentInput.equalsIgnoreCase("yes");
                if (confirmation) {
                    System.out.print("Score received on final exam:");
                    double finalExamScore = INPUT.nextDouble();
                    weightScoreOfFinalExam = finalExamWeight * finalExamScore;
                    if (confirmation) {
                        currentKnownGradeWeight += finalExamWeight;
                    }
                }
            }
        }

        System.out.print("Do you know your lab average?");
        double labScore = 0;
        studentInput = INPUT.next();
        if (studentInput.equalsIgnoreCase("y")
            || studentInput.equalsIgnoreCase("yes")) {
            System.out.print("Average lab grade:");
            labScore = INPUT.nextDouble();
            currentKnownGradeWeight += labWeight;
        }
        double weightScoreOfLab = labWeight * labScore;

        System.out.print("Do you know your project average?");
        double projectScore = 0;
        studentInput = INPUT.next();
        if (studentInput.equalsIgnoreCase("y")
            || studentInput.equalsIgnoreCase("yes")) {
            System.out.print("Average project grade:");
            projectScore = INPUT.nextDouble();
            currentKnownGradeWeight += projectWeight;
        }
        double weightScoreOfProject = projectWeight * projectScore;

        System.out.print("Do you know your participation average?");
        double participationScore = 0;
        studentInput = INPUT.next();
        if (studentInput.equalsIgnoreCase("y")
            || studentInput.equalsIgnoreCase("yes")) {
            System.out.print("Average participation grade:");
            participationScore = INPUT.nextDouble();
            currentKnownGradeWeight += participationWeight;
        }
        double weightScoreOfParticipation = participationWeight * participationScore;

        System.out.print("Do you know your quiz average?");
        double quizScore = 0;
        studentInput = INPUT.next();
        if (studentInput.equalsIgnoreCase("y")
            || studentInput.equalsIgnoreCase("yes")) {
            System.out.print("Average quiz grade:");
            quizScore = INPUT.nextDouble();
            currentKnownGradeWeight += quizWeight;
        }
        double weightScoreOfQuiz = quizWeight * quizScore;

        // Calculated weight items multiplied by the score item
        double avgOfScoreAndWeight = ((weightScoreOfExam1) + (weightScoreOfExam2)
            + (weightScoreOfFinalExam) + (weightScoreOfLab) + (weightScoreOfProject)
            + (weightScoreOfParticipation) + (weightScoreOfQuiz));

        double currentScore = avgOfScoreAndWeight / currentKnownGradeWeight;

        System.out.printf("Current grade score:%.2f\n", currentScore);

        // Verifies the user's currentScore to it's respected letter grade
        if ((90 <= currentScore)) {
            System.out.print("Your current letter grade:A \n");
        } else if ((80 <= currentScore) && (currentScore < 90)) {
            System.out.print("Your current letter grade:B \n");
        } else if ((70 <= currentScore) && (currentScore < 80)) {
            System.out.print("Your current letter grade:C \n");
        } else if ((60 <= currentScore) && (currentScore < 70)) {
            System.out.print("Your current letter grade:D \n");
        } else if (currentScore < 60) {
            System.out.print("Your current letter grade:F \n");
        }

        // Formula to get the desired grade need to obtain specific grade
        double avgToFinalLetterGrade = ((100 * GradeCalculator.getFinalScore(letterGrade))
            - avgOfScoreAndWeight) / (100 - currentKnownGradeWeight);

        // Indicator of if the user:
        // Obtain the exact grade they desired
        // Obtain the grades they desire with other grades remaining
        // Cannot obtain the desired grade
        // Explain the how many points needed to score their desired grade
        if (currentScore >= GradeCalculator.getFinalScore(letterGrade)) {
            if (!(currentKnownGradeWeight < 100)) {
                System.out.print("Congratulations! You received the " + letterGrade.toUpperCase()
                    + " that you wanted!");
            } else if (avgToFinalLetterGrade < 0) {
                System.out.print("You will receive at least a grade of " + letterGrade + ".");
            }
        } else if (avgToFinalLetterGrade > 100) {
            System.out.print(
                "Unfortunately, a grade of " + letterGrade.toUpperCase() + " is not possible.");
        } else {
            System.out.print("In order to receive a grade of " + letterGrade.toUpperCase()
                + ", \r\nyou need to score an average greater than\r\n");
            System.out.printf("or equal to %.2f in the rest of the grade items.",
                avgToFinalLetterGrade);
        }

    } // main

    public static double getFinalScore(String letterGrade) {
        double finalOverallScore = 0;

        if ((letterGrade.equalsIgnoreCase("a"))) {
            finalOverallScore = 90;
        } else if ((letterGrade.equalsIgnoreCase("b"))) {
            finalOverallScore = 80;
        } else if ((letterGrade.equalsIgnoreCase("c"))) {
            finalOverallScore = 70;
        } else if ((letterGrade.equalsIgnoreCase("d"))) {
            finalOverallScore = 60;
        } else if (letterGrade.equalsIgnoreCase("f")) {
            finalOverallScore = 0;
        }

        return finalOverallScore;
    } // getFinalScore

}
