/*
 * Circle.java 
 * Author: Cedric Amponsem 
 * Submission Date: 4/3/2026
 *
 * Purpose: This program is location where different object are created by the
 * user and instance methods are called. The user often uses these methods to
 * set up or call specific name, center values, and radius of a circle object.
 * Other methods calculate/determine different aspects of the user's circle such
 * as it's diameter, area, perimeter, and checks if the user's circle is similar
 * that of a Unit Circle. Additionally, there are some methods that are used to
 * compare with other object the user might have created such as comparisons
 * methods (isSmaller(), equals(), comparesTo()) and determining their
 * length/intersection from one another.
 */
public class Circle {

    private String name;
    private double radius;
    private double x;
    private double y;

    // Used to compare doubles. Remember, don't compare doubles directly using ==
    public static final double THRESHOLD = 0.000000001;

    // ----------------------------------------------
    // getName - returns the value of name
    // ----------------------------------------------
    public String getName() {
        return this.name;
    }

    // ----------------------------------------------
    // getX - returns the value of x
    // ----------------------------------------------
    public double getX() {
        return this.x;
    }

    // ----------------------------------------------
    // getY - returns the value of y
    // ----------------------------------------------
    public double getY() {
        return this.y;
    }

    // ----------------------------------------------
    // getRadius - returns the value of radius
    // ----------------------------------------------
    public double getRadius() {
        return this.radius;
    }

    // ----------------------------------------------
    // setName - assigns a new value to name
    // ----------------------------------------------
    public void setName(String name) {
        this.name = name.strip();
    }

    // ----------------------------------------------
    // setX - assigns a new value to x
    // ----------------------------------------------
    public void setX(double x) {
        this.x = x;
    }

    // ----------------------------------------------
    // setY - assigns a new value to y
    // ----------------------------------------------
    public void setY(double y) {
        this.y = y;
    }

    // ----------------------------------------------
    // setRadius - assigns a new value to radius
    // ----------------------------------------------
    public void setRadius(double radius) {
        if (!(radius >= 0)) {
            this.getRadius();
        } else {
            this.radius = radius;
        }
    }

    // --------------------------------------------------------
    // area - returns the area of the circle
    // --------------------------------------------------------
    public double area() {
        return Math.PI * ((this.radius) * (this.radius));
    }

    // --------------------------------------------------------
    // perimeter - returns the perimeter of the circle
    // --------------------------------------------------------
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    // --------------------------------------------------------
    // diameter - calculates the diameter of the circle
    // --------------------------------------------------------
    public double diameter() {
        return 2 * this.radius;
    }

    // --------------------------------------------------------
    // isUnitCircle - return true if the radius of this circle
    // is 1 and its center is (0,0) and false
    // otherwise.
    // --------------------------------------------------------
    public boolean isUnitCircle() {
        if ((Math.abs(this.getRadius() - 1) < THRESHOLD) && (Math.abs(this.getX() - 0) < THRESHOLD)
            && (Math.abs(this.getY() - 0) < THRESHOLD)) {
            return true;
        }
        return false;
    }

    // Checks if the executed object has the same radius and center
    public boolean equals(Circle anotherCircle) {
        // declaration and assignments of the comparison of Radius and Center values;
        double radiusComparison = Math.abs(this.getRadius() - anotherCircle.getRadius());
        double centerXComparison = Math.abs(this.getX() - anotherCircle.getX());
        double centerYComparison = Math.abs(this.getY() - anotherCircle.getY());

        if ((radiusComparison < THRESHOLD) && (centerXComparison < THRESHOLD)
            && (centerYComparison < THRESHOLD)) {
            return true;
        }

        return false;
    }

    // Calculates the distance between the executed object's center (0,0) and
    // anotherCircle
    public double distance(Circle anotherCircle) {
        // Change in executing center value and anotherCircle center value
        double deltaX = (anotherCircle.getX() - this.getX());
        double deltaY = (anotherCircle.getY() - this.getY());

        // Rise the change in center values by the power of 2
        double powerOfXValue = Math.pow(deltaX, 2.0);
        double powerOfYValue = Math.pow(deltaY, 2.0);

        // Utilize distance formula;
        double distance = Math.sqrt(powerOfXValue + powerOfYValue);

        return distance;
    }

    // Checks if the executed object is smaller than anotherCircle
    public boolean isSmaller(Circle anotherCircle) {
        // Is true when the executed circle is smaller than anotherCirlce
        if (this.diameter() < anotherCircle.diameter()) {
            return true;
        }
        return false;
    }

    // if executed object is larger than anotherCircle = return +1
    // if executed object is smaller than anotherCircle = return -1
    // if neither return 0;
    public int compareTo(Circle anotherCircle) {
        if (!(this.isSmaller(anotherCircle))) {
            if (!(this.equals(anotherCircle))) {
                return 1;
            }
        } else if (this.isSmaller(anotherCircle)) {
            return -1;
        }

        return 0;
    }

    // returns true if both circle's distances is less than the sum of their radius
    public boolean intersects(Circle anotherCircle) {
        if (this.distance(anotherCircle) < (this.getRadius() + anotherCircle.getRadius())) {
            return true;
        }
        return false;
    }

    // --------------------------------------------------------
    // toString - return a String representation of
    // this circle in the following format:
    // name: name
    // center:(x,y)
    // radius: r
    // --------------------------------------------------------
    public String toString() {
        String name = this.name;
        double x = this.x;
        double y = this.y;
        double r = this.radius;
        String center = "(" + x + "," + y + ")";
        String result = "\n name: " + name + "\n center: " + center + "\n radius: " + r;
        return result;
    }

}
