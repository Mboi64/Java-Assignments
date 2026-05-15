/*
 * Lamp.java 
 * Author: Cedric Amponsem 
 * Submission Date: 4/24/2026
 *
 * Purpose: If the user has a lamp object, the user is able to set the lamp
 * object to "light" up (set lamp to true).
 */
public class Lamp {

    /*
     * Instance variables and methods go here, you're responsible for choosing and
     * naming them.
     */
    private boolean light;

    // true = lamp produce light
    // false = lamp does not produce light
    public void setIsLit(boolean Lamp) {
        this.light = Lamp;
    } // setIsLit

    public boolean getIsLit() {
        return this.light;
    } // getIsLit

}
