/*
 * Adventure.java 
 * Author: Cedric Amponsem 
 * Submission Date: 4/24/2026
 *
 * Purpose: This program is the an interactive adventure game, where the player
 * is able to move around a fantasy world, explore/observe unique locations,
 * encounter dangers, and acquire fantastic treasure.
 */
import java.util.Scanner;

public class Adventure {
    public final static Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("Welcome to UGA Adventures: Episode I \n"
            + "The Adventure of the Cave of Redundancy Adventure \n" + "By: Cedric Amponsem \n");

        Player user = new Player();
        user.setX(0);
        user.setY(0);

        Map userMap = new Map();

        int x = user.getX();
        int y = user.getY();
        Room userLocationToMap = userMap.getRoom(x, y);

        System.out.println();

        System.out.println(userLocationToMap.getDescription());
        // creating a loop that repeats infinitely until the user dies or finds treasure
        while (userMap != null) {

            String userInput = INPUT.nextLine();

            // Updates Position's Condition
            boolean northCondition = userLocationToMap.canGoNorth();
            boolean southCondition = userLocationToMap.canGoSouth();
            boolean eastCondition = userLocationToMap.canGoEast();
            boolean westCondition = userLocationToMap.canGoWest();
            boolean positionCondition = northCondition || southCondition || eastCondition
                || westCondition;

            // Variables Of User's Position Input
            boolean northInput = userInput.equalsIgnoreCase("north");
            boolean southInput = userInput.equalsIgnoreCase("south");
            boolean eastInput = userInput.equalsIgnoreCase("east");
            boolean westInput = userInput.equalsIgnoreCase("west");
            boolean positionInput = northInput || southInput || eastInput || westInput;

            // If user changes position in a dark room...
            if (positionInput && (userLocationToMap.isDark()
                && (user.getLamp() == null || user.getLamp().getIsLit() == false))) {
                System.out.println("You have stumbled into a passing grue, and have been eaten");
                System.exit(0);
            } else {
                // -------------- GET LAMP -------------- //
                if (userInput.equalsIgnoreCase("get lamp")) {
                    if (userLocationToMap.getLamp() != null) {
                        user.setLamp(userLocationToMap.getLamp());
                        userLocationToMap.clearLamp();
                        System.out.println("OK");
                    } else {
                        System.out.println("No lamp present");
                    } // if-else

                    // -------------- LIGHT'S LAMP -------------- //
                } else if (userInput.equalsIgnoreCase("light lamp")) {
                    if (user.getLamp() != null) {
                        user.getLamp().setIsLit(true);
                        System.out.println("OK");
                    } else {
                        System.out.println("You don\'t have the lamp to light");
                    } // if-else

                    // -------------- NORTH MOVEMENT -------------- //
                } else if (northInput) {
                    x -= 1;
                    user.setX(x);
                    if (northCondition) {
                        userLocationToMap = userMap.getRoom(x, y); // Updated
                        if (userLocationToMap.isDark()
                            && (user.getLamp() == null || user.getLamp().getIsLit() == false)) {
                            System.out.println(
                                "It is pitch black, you can\'t see anything. You may be eaten by a grue!");
                        } else {
                            System.out.println(userLocationToMap.getDescription());
                        }
                    } else {
                        System.out.println("Can\'t go that way");
                        x += 1;
                        user.setX(x);
                        user.setY(y);
                        userLocationToMap = userMap.getRoom(x, y);
                    }

                    // -------------- SOUTH MOVEMENT -------------- //
                } else if (southInput) {
                    x += 1;
                    user.setX(x);
                    if (southCondition) {
                        userLocationToMap = userMap.getRoom(x, y); // Updated
                        if (userLocationToMap.isDark()
                            && (user.getLamp() == null || user.getLamp().getIsLit() == false)) {
                            System.out.println(
                                "It is pitch black, you can\'t see anything. You may be eaten by a grue!");
                        } else {
                            System.out.println(userLocationToMap.getDescription());
                        }
                    } else {
                        System.out.println("Can\'t go that way");
                        x -= 1;
                        user.setX(x);
                        user.setY(y);
                        userLocationToMap = userMap.getRoom(x, y);
                    }

                    // -------------- EAST MOVEMENT -------------- //
                } else if (eastInput) {
                    y += 1;
                    user.setY(y);
                    if (eastCondition) {
                        userLocationToMap = userMap.getRoom(x, y); // Updated
                        if (userLocationToMap.isDark()
                            && (user.getLamp() == null || user.getLamp().getIsLit() == false)) {
                            System.out.println(
                                "It is pitch black, you can\'t see anything. You may be eaten by a grue!");
                        } else {
                            System.out.println(userLocationToMap.getDescription());
                        }
                    } else {
                        System.out.println("Can\'t go that way");
                        y -= 1;
                        user.setY(y);
                        user.setX(x);
                        userLocationToMap = userMap.getRoom(x, y);
                    }

                    // -------------- WEST MOVEMENT -------------- //
                } else if (westInput) {
                    y -= 1;
                    user.setY(y);
                    if (westCondition) {
                        userLocationToMap = userMap.getRoom(x, y); // Updated
                        if (userLocationToMap.isDark()
                            && (user.getLamp() == null || user.getLamp().getIsLit() == false)) {
                            System.out.println(
                                "It is pitch black, you can\'t see anything. You may be eaten by a grue!");
                        } else {
                            System.out.println(userLocationToMap.getDescription());
                        }
                    } else {
                        System.out.println("Can\'t go that way");
                        y += 1;
                        user.setY(y);
                        user.setX(x);
                        userLocationToMap = userMap.getRoom(x, y);
                    }

                }

                // -------------- LOOK -------------- //
                else if (userInput.equalsIgnoreCase("look")) {
                    if (userLocationToMap.isDark()
                        && (user.getLamp() == null || user.getLamp().getIsLit() == false)) {
                        System.out.println(
                            "It is pitch black, you can\'t see anything. You may be eaten by a grue!");
                    } else {
                        System.out.println(userLocationToMap.getDescription());
                        if (userLocationToMap.getLamp() != null) {
                            System.out.println("There us an old lamp that was made long ago here.");
                        } // if (lamp exist)
                        if (userLocationToMap.getKey() != null) {
                            System.out.println(
                                "You see the outline of a key on a dusty shelf that\'s covered in dust.");
                        } // if (key exist)
                        if (userLocationToMap.getChest() != null) {
                            System.out.println(
                                "There is a large, wooden, massive, oaken chest here with the word \"CHEST\" carved into it");
                        } // if (chest exist)
                        if (positionCondition) {
                            System.out.print("Exits are: ");
                            if (northCondition) {
                                System.out.println("north");
                            }
                            if (southCondition) {
                                System.out.println("south");
                            }
                            if (eastCondition) {
                                System.out.println("east");
                            }
                            if (westCondition) {
                                System.out.println("west");
                            }
                        } // if-else (determines possible exits)
                    } // if else (isDark)
                } // if-else (look)

                // -------------- Get Key -------------- //
                else if (userInput.equalsIgnoreCase("get key")) {
                    if (userLocationToMap.getKey() != null) {
                        user.setKey(userLocationToMap.getKey());
                        userLocationToMap.clearKey();
                        System.out.println("OK");
                    } else {
                        System.out.println("No key present");
                    } // if-else
                } // if-else (get key)

                // -------------- Open Chest -------------- //
                else if (userInput.equalsIgnoreCase("open chest")) {
                    if (userLocationToMap.getChest() != null) {
                        if (userLocationToMap.getChest().isLocked() != true) {
                            System.out.println(userLocationToMap.getChest().getContents());
                            System.exit(0);
                        } else {
                            System.out.println("The chest is locked.");
                        } // if-else (if unlocked)
                    } else {
                        System.out.println("No chest present");
                    } // if-else (if chest present)
                } // if-else (open chest)

                // -------------- Unlock Chest -------------- //
                else if (userInput.equalsIgnoreCase("unlock chest")) {
                    if (userLocationToMap.getChest() != null) {
                        if (user.getKey() != null) {
                            userLocationToMap.getChest().unLock(user.getKey());
                            System.out.println("OK");
                        } else {
                            System.out.println("Need a key to do any unlocking!");
                        } // if-else (user has key to unlock)
                    } else {
                        System.out.println("No chest to unlock");
                    } // if-else (chest existence)
                } // if-else (unlock chest)

                // -------------- Other Input -------------- //
                else {
                    System.out.println("I\'m sorry I don\'t know how to do that.");
                }
            } // if-else (checks if user move when dark)
        } // while
    }

}
