/*
 * CircleTester.java Author: Cedric Amponsem Submission Date: 4/3/2026
 *
 * Purpose: This program allows the user to create a circle by labeling the
 * cirle's name, x and y values, and radius (which can be changed at anytime).
 * With this, the user can use different methods to determine the established
 * circle's measurements such as its diameter, area and perimeter. If the user
 * creates an additional circle, they can compare and determine the size of both
 * circles as well as their distances from each other. Additionally, the user
 * can also check if their circle is a type of unit circle as well as if it
 * intersect with other circle.
 */
public class CircleTester {
    public static final double THRESHOLD = 0.000000001;

    public static void main(String[] args) {

        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        circle1.setName("Circle 1");
        circle1.setX(0.0);
        circle1.setY(0.0);
        circle1.setRadius(2);

        circle2.setName("Circle 2");
        circle2.setX(2.0);
        circle2.setY(1.0);
        circle2.setRadius(2);

        System.out.println("circle1=" + circle1);
        System.out.println("circle2=" + circle2);

        // If the method setRadius is implemented correctly,
        // a call to setRadius with a negative number
        // will not change the value of the circle's radius.
        //
        circle1.setRadius(-2.0);

        // This is a unit test. It is best to have tests output pass or fail instead of
        // just a bunch of values.
        // Notice how the double comparison is done
        if (Math.abs(2 - circle1.getRadius()) < THRESHOLD)
            System.out.println("PASSED: Set Radius");
        else
            System.out.println("FAILED: Set Radius");

        //
        // Reset the center of circle1 (-3.0,4.0)
        //
        circle1.setX(-3.0);
        circle1.setY(4.0);

        // print circle1 characteristics (center and radius), use a statement similar
        // to the previous println statements. Note that is not necessary to call
        // the method toString, why?
        System.out.println("circle1=" + circle1);

        // set the circle2 radius to 5.3
        // print circle2 characteristics (center and radius), use a statement similar to
        // the first and
        // second println statements
        circle2.setRadius(5.3);
        System.out.println("circle1=" + circle2);

        // print circle1 diameter, area and perimeter
        System.out.println("circle1= \n diameter: " + circle1.diameter() + "\n area: "
            + circle1.area() + "\n perimeter: " + circle1.perimeter());

        // print circle2 diameter, area and perimeter
        System.out.println("circle2= \n diameter: " + circle2.diameter() + "\n area: "
            + circle2.area() + "\n perimeter: " + circle2.perimeter());

        // display whether circle1 is a unit circle
        System.out.println("circle1 is a unit circle: " + circle1.isUnitCircle());

        // display whether circle2 is a unit circle
        System.out.println("circle2 is a unit circle: " + circle2.isUnitCircle());

        // your additional tests should be placed below here. Make sure to include at
        // least 3 test cases
        // for each method you write. It is best to write proper unit tests which print
        // pass, fail for each
        // test instead of just dumping values to the screen.

        System.out.println("------ Test Cases: ------");

        Circle circleNew = new Circle();
        Circle circleEqual = new Circle();
        Circle circleOdd = new Circle();
        circleNew.setX(0);
        circleNew.setY(0);
        circleNew.setRadius(1);

        circleEqual.setX(0);
        circleEqual.setY(0);
        circleEqual.setRadius(1);

        circleOdd.setX(2.0);
        circleOdd.setY(3);
        circleOdd.setRadius(0);

        // ------ isUnitCircle() Test: ------
        // 1. Should return: PASSED
        // 2. Should return: FAILED
        if (circleNew.isUnitCircle()) {
            System.out.println("PASSED: It is a Unit Circle");
        } else {
            System.out.println("FAILED: It is not a Unit Circle");
        }

        if (circleOdd.isUnitCircle()) {
            System.out.println("PASSED: It is a Unit Circle");
        } else {
            System.out.println("FAILED: It is not a Unit Circle");
        }

        System.out.println();

        // ------ equals() Test: ------
        // 1. Should return: FAILED
        // 2. Should return: PASSED
        if (circleNew.equals(circle1)) {
            System.out.println("PASSED: Both circles equal each other");
        } else {
            System.out.println("FAILED: Both circles do not equal each other");
        }

        if (circleNew.equals(circleEqual)) {
            System.out.println("PASSED: Both circles equal each other");
        } else {
            System.out.println("FAILED: Both circles do not equal each other");
        }

        System.out.println();

        // ------ distance() Test: ------
        // Should display the proper distance between two circles
        System.out.println(
            "The distance between both circleNew and circle2 is: " + circleNew.distance(circle2));

        System.out.println();

        // ------ isSmaller() Test: ------
        // 1. Should display: true
        // 2. Should display: false
        if (circleNew.isSmaller(circle1)) {
            System.out.println("PASSED: circleNew is smaller than circle1");
        } else {
            System.out.println("FAILED: circleNew is not smaller than circle1");
        }

        if (circleNew.isSmaller(circleEqual)) {
            System.out.println("PASSED: circleNew is smaller than circleEqual");
        } else {
            System.out.println("FAILED: circleNew is not smaller than circleEqual");
        }

        System.out.println();

        // ------ compareTo() Test: ------
        // 1. Should work as -1
        // 2. Should work as 0
        // 3. Should work as 1
        System.out.print("circleNew is larger/smaller/similar compared to circle1: ");
        if (circleNew.compareTo(circle1) < 0) {
            System.out.println("it small");
        } else if (circleNew.compareTo(circle1) == 0) {
            System.out.println("about the same");
        } else if (circleNew.compareTo(circle1) > 0) {
            System.out.println("it HUGE");
        }

        System.out.print("circleNew is larger/smaller/similar compared to this circleEqual: ");
        if (circleNew.compareTo(circleEqual) < 0) {
            System.out.println("it smol");
        } else if (circleNew.compareTo(circleEqual) == 0) {
            System.out.println("about the same");
        } else if (circleNew.compareTo(circle1) > 0) {
            System.out.println("it HUGE");
        }

        System.out.print("circle1 is larger/smaller/similar compared to circleNew: ");
        if (circle1.compareTo(circleNew) < 0) {
            System.out.println("it smol");
        } else if (circle1.compareTo(circleNew) == 0) {
            System.out.println("about the same");
        } else if (circle1.compareTo(circleNew) > 0) {
            System.out.println("it HUGE");
        }

        System.out.println();

        // ------ intersects() Test: ------
        // 1. Should return true
        // 2. Should return false
        System.out.println("Both circleNew and circle2 intercept with each other: "
            + circleNew.intersects(circle2));
        System.out.println("Both circleNew and circleOdd intercept with each other: "
            + circleNew.intersects(circleOdd));
    }

}
