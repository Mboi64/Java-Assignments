
/*
 * ClassifyMessage.java 
 * Author: Cedric Amponsem 
 * Submission Date: 2/13/2026
 *
 * Purpose: Similar to Lab 3 (ParseTheTweet), this program utilize short
 * messages from tweets to help first responders to act quickly based on the
 * given information. This program categorize certain messages (whether it falls
 * in line with "Alert", "Need", "Offer", "Info", or "Unknown") and the
 * longitude and latitude location (which determines whether the message/event
 * in within range for first responders) of the user's input.
 */
import java.util.Scanner;

public class ClassifyMessage {
    public final static Scanner INPUT = new Scanner(System.in);

    enum MessageCategory {
        NEED, OFFER, ALERT, INFO, UNKNOWN
    }

    public static void main(String[] args) {

        // Constants for longitude and latitude
        final double NORTH = 40.231315; // latitude
        final double SOUTH = 39.882343; // latitude
        final double EAST = -104.907864; // longitude
        final double WEST = -105.743511; // longitude

        // User's input
        System.out.println("Please enter a formatted message:");
        String catString = INPUT.next().trim();
        double latitude = INPUT.nextDouble();
        double longitude = INPUT.nextDouble();
        String payload = INPUT.nextLine().trim();

        // Multibranching Categorization of catString
        System.out.printf("Category: \t");
        if (catString.equalsIgnoreCase("need")) {
            System.out.println(MessageCategory.NEED);
        } else if (catString.equalsIgnoreCase("fire") || catString.equalsIgnoreCase("smoke")) {
            System.out.println(MessageCategory.ALERT);
        } else if (catString.equalsIgnoreCase("offer")) {
            System.out.println(MessageCategory.OFFER);
        } else if (catString.equalsIgnoreCase("structure") || catString.equalsIgnoreCase("road")
            || catString.equalsIgnoreCase("photo") || catString.equalsIgnoreCase("evac")) {
            System.out.println(MessageCategory.INFO);
        } else {
            System.out.println(MessageCategory.UNKNOWN);
        }

        // Geological Range Confirmation
        boolean isInRange = (latitude >= SOUTH) && (latitude <= NORTH) && (longitude >= WEST)
            && (longitude <= EAST);

        if (isInRange) {
            isInRange = true;
        } else {
            isInRange = false;
        }

        // User's Output
        System.out.println("Raw Cat: \t" + catString);
        System.out.println("Message: \t" + payload);
        System.out.println("Latitude: \t" + latitude);
        System.out.println("Longitude: \t" + longitude);
        System.out.println("In Range: \t" + isInRange);

    }
}
