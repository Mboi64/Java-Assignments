
/*
 * ParseTheTweet.java 
 * Author: Cedric Amponsem 
 * Submission Date: 2/5/2026
 *
 * Purpose: This program utilizes specific Twitter notifications known as
 * "Tweak the Twitter", or TtT, (structured messages that people can send during
 * certain disasters) into a readable format. According to the user's input, the
 * program will read their hashtags and list out the type of report, the details
 * of the report, and the location from which the information is being reported
 * on (including longitude and latitude).
 */
import java.util.Scanner;

public class ParseTheTweet {
    public final static Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a tweet below");

        String tweet = INPUT.nextLine();

        // Placement Identifiers
        int start = tweet.indexOf("#");
        int end = tweet.indexOf(";");

        // Type and value
        String separateValue = tweet.substring(start + 4, end);
        String value = separateValue.trim().toUpperCase();

        // Moving to the next data type //
        tweet = tweet.substring(end + 1);
        end = tweet.indexOf(";");

        // Detail and value
        separateValue = tweet.substring(start + 4, end).replace(",", "-");
        String value1 = separateValue.trim();

        // Moving to the next data type //
        tweet = tweet.substring(end + 1);
        end = tweet.indexOf(";");

        // Location and value
        separateValue = tweet.substring(start + 4, end).replace(",", "-");
        String value2 = separateValue.trim();

        // Moving to the next data type //
        tweet = tweet.substring(end + 1);
        end = tweet.indexOf(";");

        // Latitude and value
        separateValue = tweet.substring(start + 4, end);
        String value3 = separateValue.trim();

        // Moving to the next data type
        tweet = tweet.substring(end + 1);
        end = tweet.indexOf(";");

        // Longitude and value
        separateValue = tweet.substring(start + 4, end);
        String value4 = separateValue.trim();

        // Output Value
        System.out.println("Type:     \t" + value);
        System.out.println("Detail:   \t" + value1);
        System.out.println("Location: \t" + value2);
        System.out.println("Latitude: \t" + value3);
        System.out.println("Longitude:\t" + value4);
    }

}
