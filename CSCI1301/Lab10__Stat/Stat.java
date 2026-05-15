/*
 * Stat.java 
 * Author: Cedric Amponsem 
 * Submission Date: 4/10/26
 *
 * Purpose: This program takes in an array of data and, upon creating a new
 * object of the input data, the user can use methods to find different
 * information needed from the set data (such as finding the minimum, maximum,
 * average, and frequency of appearance from the data) without manipulating or
 * changing the original data.
 */
public class Stat {
    private double[] data;

    public Stat() {
        this.data = new double[1];
        this.data[0] = 0.0;
    } // Default Constructor

    public Stat(double[] d) {
        this.setData(d);
    } // Constructor (Deep Copy)

    public double[] getData() {
        double[] newArray = new double[this.data.length];
        for (int i = 0; i < this.data.length; i++) {
            newArray[i] = this.data[i];
        }
        return newArray;
    } // getData (Deep Copy)

    public void setData(double[] d) {
        this.data = new double[d.length];
        for (int i = 0; i < d.length; i++) {
            this.data[i] = d[i];
        }
    } // setData (Deep Copy)

    public boolean equals(Stat s) {
        double[] comparedData = s.getData();
        if (this.data.length == comparedData.length) {
            for (int i = 0; i < this.data.length; i++) {
                if (this.data[i] != comparedData[i]) {
                    return false;
                }
            } // for
        } else {
            return false;
        } // if

        return true;
    } // equals

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < this.data.length; i++) {
            result += this.data[i];
            if (i < this.data.length - 1) {
                result += ", ";
            }
        }
        return result + "]";
    } // toString

    public double min() {
        double minimum = this.data[0];
        for (double data : this.data) {
            if (minimum > data) {
                minimum = data;
            }
        } // for
        return minimum;
    } // min

    public double max() {
        double maximum = this.data[0];
        for (double data : this.data) {
            if (maximum < data) {
                maximum = data;
            }
        }
        return maximum;
    }// max

    public double average() {
        double result = 0;
        for (double data : this.data) {
            result += data;
        }
        result = result / this.data.length;
        return result;
    } // average

    public double mode() {
        int counter = 0;
        int highestCount = 0;
        int repeat = 0; // indicates if there are more than one instance of a value
        double result = 0;
        final double THRESHOLD = 0.000000001; // comparing doubles
        if (this.data.length != 1) {
            for (double data : this.data) {
                for (int i = 0; i < this.data.length; i++) {
                    if (Math.abs(data - this.data[i]) < THRESHOLD) {
                        counter++;
                    }
                } // for
                if (counter > highestCount) {
                    result = data;
                    highestCount = counter;
                    repeat = 0;
                } else if (counter == highestCount && !(Math.abs(data - result) < THRESHOLD)) {
                    repeat++;
                } // if-else
                counter = 0;
            } // for-each
        } else {
            return this.data[0];
        } // if-else
        if (repeat > 1) {
            return Double.NaN;
        }
        return result;
    } // mode
}
