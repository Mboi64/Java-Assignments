/*
 * FindTheSums.java 
 * Author: Cedric Amponsem 
 * Submission Date: 4/24/2026
 *
 * Purpose: The user input a multidimensional array and sum needed to find.
 * Returns an array of the assigned sum of the array vertically or horizontally.
 */

public class FindTheSums {

    // --------------------- Array to String --------------------- //
    public static String arrayRowList(int[] a) {
        String result = "";
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                result += a[i];
            } else {
                result += a[i] + " ";
            }
        }
        return result;
    } // arrayRowList

    public static String arrayToString(int[][] a) {
        String result = "";
        for (int[] array : a) {
            result += arrayRowList(array);
            result += "\n";
        }
        int doubleTheArea = (a.length * a[0].length) * 2;
        result = result.substring(0, (doubleTheArea) - 1);
        return result;
    } // arrayToString

    // --------------------- Horizontal Sum --------------------- //
    public static int[] arrayRow(int[] a, int[] b, int start, int end) {
        for (int i = start; i <= end; i++) {
            b[i] = a[i];
        }
        return b;
    } // arrayRow

    public static int[][] horizontalSums(int[][] a, int sumToFind) {
        int[][] b = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            int result = 0;
            int startIndex = 0;
            for (int j = startIndex; j < a[i].length; j++) {
                result += a[i][j];
                // if the result == sumToFind, it assigns the proper values to b and the
                // startIndex will change (restarting the j initialization)
                if (result == sumToFind) {
                    b[i] = arrayRow(a[i], b[i], startIndex, j);
                    j = startIndex;
                    startIndex++;
                    result = 0;
                    // if the result > sumToFind, b[i][j] is assign to 0 automatically and will
                    // change the starting value
                } else if (result > sumToFind) {
                    j = startIndex;
                    startIndex++;
                    result = 0;
                }
            } // for
        } // for

        return b;
    } // horizontalSums

    // --------------------- Vertical Sum --------------------- //
    public static int[][] verticalSums(int[][] a, int sumToFind) {
        int[][] b = new int[a.length][a[0].length];

        // reads the first number of each column
        for (int i = 0; i < a[0].length; i++) {
            int result = 0;
            int startPoint = 0;
            for (int j = startPoint; j < a.length; j++) {
                result += a[j][i];
                // if the result == sumToFind, it assigns the proper values to b and the
                // startIndex will change (restarting the j initialization)
                if (result == sumToFind) {
                    for (int k = startPoint; k <= j; k++) {
                        b[k][i] = a[k][i];
                    } // for
                    j = startPoint;
                    startPoint++;
                    result = 0;
                    // if the result > sumToFind, b[i][j] is assign to 0 automatically and will
                    // change the starting value
                } else if (result > sumToFind) {
                    j = startPoint;
                    startPoint++;
                    result = 0;
                }
            } // for
        } // for
        
        return b;
    }
}
