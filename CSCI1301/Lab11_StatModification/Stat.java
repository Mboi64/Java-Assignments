/*
 * Stat.java 
 * Author: Cedric Amponsem 
 * Submission Date: 4/17/26
 *
 * Purpose: This program takes in an array of data, and, upon creating a new
 * object of the input data, the user can use methods to find different
 * information needed from the set data (such as finding the minimum, maximum,
 * average, frequency of appearance from the data, and determine how far the
 * data is being spread apart from its average and its standard deviation,).
 * Additionally, the user can input multiple different number data types (float,
 * long, int) as well as have the ability to reset the data they into an empty
 * array or add more data to the end of the array.
 */
public class Stat {
    private double[] data;

    public Stat() {
        this.data = new double[0];
    } // Default Constructor

    public Stat(double[] d) {
        setData(d);
    } // Constructor (data type: double)

    public Stat(float[] f) {
        setData(f);
    } // Constructor (data type: float)

    public Stat(int[] i) {
        setData(i);
    } // Constructor (data type: integer)

    public Stat(long[] lo) {
        setData(lo);
    } // COnstructor (data type: long)

    public void setData(double[] d) {
        if (d != null) {
            this.data = new double[d.length];
            for (int i = 0; i < d.length; i++) {
                this.data[i] = d[i];
            } // for
        } else {
            this.data = new double[0];
        } // if-else
    } // setData (deep copy; data type: double)

    // Find a Way to SIMPLIFY

    public void setData(float[] f) {
        if (f != null) {
            this.data = new double[f.length];
            for (int i = 0; i < f.length; i++) {
                this.data[i] = f[i];
            } // for
        } // if
    } // setData (deep copy; data type: float)

    public void setData(int[] i) {
        if (i != null) {
            this.data = new double[i.length];
            for (int j = 0; j < i.length; j++) {
                this.data[j] = i[j];
            } // for
        } // if
    } // setData (deep copy; data type: int)

    public void setData(long[] lo) {
        if (lo != null) {
            this.data = new double[lo.length];
            for (int i = 0; i < lo.length; i++) {
                this.data[i] = lo[i];
            } // for
        } // if
    } // setData (deep copy; data type: long)

    public double[] getData() {
        double[] arr = new double[this.data.length];
        if (!isEmpty()) {
            for (int i = 0; i < this.data.length; i++) {
                arr[i] = this.data[i];
            } // for
        } // if
        return arr;
    } // getData (Deep Copy)

    public boolean equals(Stat s) {
        if (s != null && this.data.length == s.getData().length && !isEmpty()) {
            final double THRESHOLD = 0.000000001;
            double[] comparedData = s.getData();
            for (int i = 0; i < this.data.length; i++) {
                boolean notEqualValueData = !(Math.abs(this.data[i] - comparedData[i]) < THRESHOLD);
                if (notEqualValueData) {
                    return false;
                } // if
            } // for
        } else {
            return false;
        } // if-else

        return true;
    } // equals

    public void reset() {
        this.data = new double[0];
    } // reset

    public void append(double[] d) {
        if (d != null) {
            double[] arr = new double[d.length + this.data.length];
            for (int i = 0; i < this.data.length; i++) {
                arr[i] = this.data[i];
            } // fpr (old array)

            for (int i = 0; i < d.length; i++) {
                arr[this.data.length + i] = d[i];
            } // for (new array)

            this.data = new double[arr.length];
            setData(arr);
        }
    } // append (data type: double)

    public void append(float[] f) {
        if (f != null) {
            double[] arr = new double[f.length + this.data.length];
            for (int i = 0; i < this.data.length; i++) {
                arr[i] = this.data[i];
            } // fpr (old array)

            for (int i = 0; i < f.length; i++) {
                arr[this.data.length + i] = f[i];
            } // for (new array)

            this.data = new double[arr.length];
            setData(arr);
        }
    } // append (data type: float)

    public void append(int[] i) {
        if (i != null) {
            double[] arr = new double[i.length + this.data.length];
            for (int j = 0; j < this.data.length; j++) {
                arr[j] = this.data[j];
            } // fpr (old array)

            for (int j = 0; j < i.length; j++) {
                arr[this.data.length + j] = i[j];
            } // for (new array)

            this.data = new double[arr.length];
            setData(arr);
        }
    } // append (data type: integer)

    public void append(long[] lo) {
        if (lo != null) {
            double[] arr = new double[lo.length + this.data.length];
            for (int i = 0; i < this.data.length; i++) {
                arr[i] = this.data[i];
            } // fpr (old array)

            for (int i = 0; i < lo.length; i++) {
                arr[this.data.length + i] = lo[i];
            } // for (new array)

            this.data = new double[arr.length];
            setData(arr);
        }
    } // append (data type: long)

    public boolean isEmpty() {
        return this.data == null || this.data.length == 0;
    } // isEmpty

    @Override
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            for (int i = 0; i < this.data.length; i++) {
                result += this.data[i];
                if (i < this.data.length - 1) {
                    result += ", ";
                } // if
            } // for
        } // if
        return result + "]";

    } // toString

    public double min() {
        double minimum = 0;
        if (!isEmpty()) {
            minimum = this.data[0];
            for (double data : this.data) {
                if (minimum > data) {
                    minimum = data;
                } // if
            } // for
        } else {
            return Double.NaN;
        }
        return minimum;
    } // min

    public double max() {
        double maximum = 0;
        if (!isEmpty()) {
            maximum = this.data[0];
            for (double data : this.data) {
                if (maximum < data) {
                    maximum = data;
                } // if
            } // for
        } else {
            return Double.NaN;
        } // if-else
        return maximum;
    }// max

    public double average() {
        double result = 0;
        if (!isEmpty()) {
            for (double data : this.data) {
                result += data;
            } // for
        } else {
            return Double.NaN;
        } // if-else
        return result / this.data.length;
    } // average

    public double mode() {
        int counter = 0;
        int highestCount = 0;
        int repeat = 0; // indicates if there are more than one instance of a value
        double result = 0;
        final double THRESHOLD = 0.000000001; // comparing doubles
        if (!isEmpty()) {
            for (double data : this.data) {
                counter = occursNumberOfTimes(data);
                if (counter > highestCount) {
                    result = data;
                    highestCount = counter;
                    repeat = 0;
                } else if (counter == highestCount && !(Math.abs(data - result) < THRESHOLD)) {
                    repeat++;
                } // if-else
                counter = 0;
            } // for-each
        }
        if (repeat > 0 || isEmpty()) {
            return Double.NaN;
        } // if-else

        return result;
    } // mode

    private int occursNumberOfTimes(double value) {
        int count = 0;
        final double THRESHOLD = 0.000000001;
        for (double data : this.data) {
            if (Math.abs(data - value) < THRESHOLD) {
                count += 1;
            } // for
        } // for
        return count;
    } // occuranceNumberOfTimes

    public double variance() {
        double result = 0;
        // Adds the value minus the mean
        if (!isEmpty()) {
            double average = average();
            for (double data : this.data) {
                double diff = Math.abs(data - average);
                result += Math.pow(diff, 2);
            } // for
        } else {
            return Double.NaN;
        } // if-else

        return result / this.data.length;
    } // variance

    public double standardDeviation() {
        double result = 0;

        if (!isEmpty()) {
            result = Math.sqrt(variance());
        } else {
            return Double.NaN;
        } // if-felse

        return result;
    } // standardDeviation

}
