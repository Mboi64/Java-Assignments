
/*
 * RockPaperScissors.java 
 * Author: Cedric Amponsem 
 * Submission Date: 2/27/2026
 *
 * Purpose: This program is a rock, paper, scissors game against a computer
 * program. The user first input a specific points to win against the computer,
 * then plays against a computer until either the computer or the person is able
 * to win up to the desired point.
 */
import java.util.Scanner;

public class RockPaperScissors {
    public static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        // Declarations and Iteration
        int playerScore, opponentScore, pointsToWin;
        String playerChoice;
        Boolean userRock, userPaper, userScissors, botRock, botPaper, botScissors;
        playerScore = 0;
        opponentScore = 0;

        // Points indicator
        System.out.print("Points to win: ");
        pointsToWin = INPUT.nextInt();

        while ((playerScore < pointsToWin) && (opponentScore < pointsToWin)) {

            // User's Input
            System.out.print("Rock, paper, or scissors? ");
            playerChoice = INPUT.next();

            // Checks if user input the correct "rock", "paper" or "scissors"
            while (!(playerChoice.equalsIgnoreCase("rock"))
                && !(playerChoice.equalsIgnoreCase("paper"))
                && !(playerChoice.equalsIgnoreCase("scissors"))) {
                System.out.print("Rock, paper, or scissors? ");
                playerChoice = INPUT.next();
            }

            // Displays the opponent's move
            String computerMove = ComputerOpponent.getMove();

            // Simplified assignments
            userRock = playerChoice.equalsIgnoreCase("rock");
            userPaper = playerChoice.equalsIgnoreCase("paper");
            userScissors = playerChoice.equalsIgnoreCase("scissors");

            botRock = computerMove.equals("rock");
            botPaper = computerMove.equals("paper");
            botScissors = computerMove.equals("scissors");

            // Rules to determine whether the user and computer gets a score or a tie
            if ((userRock) && (botRock) || (userPaper) && (botPaper) // Draw
                || (userScissors) && (botScissors)) {
                System.out.printf(", so it's a tie. (%d-%d)\n", playerScore, opponentScore);

            } else if ((userRock) && (botScissors) || (userPaper) && (botRock) // User Wins
                || (userScissors) && botPaper) {
                playerScore += 1;
                System.out.printf(", so you win! (%d-%d)\n", playerScore, opponentScore);

            } else if ((userScissors) && (botRock) || (userRock) && (botPaper) // Computer Wins
                || (userPaper) && (botScissors)) {
                opponentScore += 1;
                System.out.printf(", so you lose. (%d-%d)\n", playerScore, opponentScore);

            }

        }

        // Determines the winner
        if (playerScore > opponentScore) {
            System.out.print("Congratulations! You won!");
        } else {
            System.out.print("Sorry, you lost. Better luck next time!");
        }

        INPUT.close();
    }
}
