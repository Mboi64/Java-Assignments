/*
 * Chest.java 
 * Author: Cedric Amponsem 
 * Submission Date: 4/24/2026
 *
 * Purpose: The chest class helps assign/view the contents within the chest of
 * the game. It also determines the chest's condition, whether the chest is
 * locked or unlocked. If the user does not have the key assigned to the chest
 * object, then the chest remains locked. If they have the key object, the user
 * is allowed to unlock the chest.
 */
public class Chest {

    /*
     * Instance variables go here, you're responsible for choosing which ones are
     * needed and naming them
     */
    private boolean chestLockCondition; // false means closed; true means open
    private String chestContent;
    private Key chestKey;

    /**
     * This method is used by the Map class, you won't need to call it yourself It
     * should result in this chest being locked and storing which key locked it.
     */
    public void lock(Key theKey) {
        this.chestKey = theKey;
        if (this.chestKey == theKey) {
            this.chestLockCondition = false;
        }
    }

    /**
     * If theKey is the same key that was used to lock this chest, then the chest is
     * unlocked. Otherwise this method does nothing.
     */
    public void unLock(Key theKey) {
        if (this.chestKey == theKey) {
            this.chestLockCondition = true;
        }
    }

    /**
     * Should return true if the chest is locked, false otherwise
     */
    public boolean isLocked() {
        if (!chestLockCondition) { // if it is lock = false (closed) it is true;
            return true;
        }
        return false;
    }

    /**
     * Return a string describing the contents of the chest.
     */
    public String getContents() {
        return this.chestContent;
    }

    /**
     * Set the contents of the chest to this string. You should not need to call
     * this method in your program (though you have to implement it anyway).
     */
    public void setContents(String contents) {
        this.chestContent = contents;
    }

}
