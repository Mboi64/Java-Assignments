/*
 * Player.java 
 * Author: Cedric Amponsem 
 * Submission Date: 4/24/2026
 *
 * Purpose: This class represents the user playing the game by their current
 * location, obtained items (keys, lamp).
 */
public class Player {

    private Lamp theLamp;
    private Key theKey;
    private Map[][] theMap;

    public void setX(int x) {
        this.theMap = new Map[x + 1][];
    } // setX

    public void setY(int y) {
        this.theMap[getX()] = new Map[y + 1];
    } // setY

    public int getX() {
        return this.theMap.length - 1;
    } // getX

    public int getY() {
        return this.theMap[0].length - 1;
    } // getY

    // Used if the player acquires a lamp
    public void setLamp(Lamp obtainedLamp) {
        this.theLamp = obtainedLamp;
    } // setLamp

    public Lamp getLamp() {
        return this.theLamp;
    } // getLamp

    // Used if the player acquires a key
    public void setKey(Key obtainedKey) {
        this.theKey = obtainedKey;
    } // setKey

    public Key getKey() {
        return this.theKey;
    } // getKey

}
