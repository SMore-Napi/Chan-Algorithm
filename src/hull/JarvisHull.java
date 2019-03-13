package hull;

import calculation.ArrayHelper;
import elementsStructure.Point;

import java.util.Stack;

import static calculation.Calculation.getLengthBetweenPoints;

public class JarvisHull {
    private static Point[][] points;
    private static int max;
    private static int m;

    /**
     * Build the hull from input points
     *
     * @param inputPoints points which hull to build
     * @return hull
     * @throws IllegalStateException
     */
    public static Stack<Point> getJarvisHull(Point[][] inputPoints, int maxStepsCount) {

        max = maxStepsCount;
        m = 0;
        // if there is only one group then return whole group
        if (inputPoints.length == 1) {
            Stack<Point> hull = new Stack<>();
            for (int i = 0; i < inputPoints[0].length; i++) {
                hull.push(inputPoints[0][i]);
            }
            return hull;
        }

        points = inputPoints;

        // Build and return the hull
        return buildHull();
    }

    /**
     * Finds border points
     *
     * @return stack which contains the hull
     */

    private static Stack<Point> buildHull() {
        Stack<Point> hull = new Stack<>();

        // Finds the minimal point and places it to the end of the array
        Point startPoint = ArrayHelper.findMinPoint(points);

        Point currentPoint = startPoint;
        hull.push(startPoint);


        while (true) {
            // Algorithm made more than max steps
            if (m > max) {
                hull = null;
                break;
            }
            m++;

            Point minPoint = findMinimalPointGroup(currentPoint, points[1]);

            // Scans and finds minimal point in every group
            for (int i = 0; i < points.length; i++) {

                Point minPointGroup = findMinimalPointGroup(currentPoint, points[i]);

                // Compares with currentPoint
                double vectorComparator = compareTwoVectors(currentPoint, minPoint, currentPoint, minPointGroup);

                // if this point has less polar corner than minPoint then it becomes a minimal Point
                if (vectorComparator < 0) {
                    minPoint = minPointGroup;
                }
                // if this point has the same polar corner but is placed farther than minimal point
                else if (vectorComparator == 0) {
                    if (getLengthBetweenPoints(currentPoint, minPoint) < getLengthBetweenPoints(currentPoint, minPointGroup)) {
                        minPoint = minPointGroup;
                    }
                }

            }

            // if hull is completed
            if (minPoint.equals(startPoint)) {
                break;
            }

            // Saves new minimal point
            currentPoint = minPoint;
            hull.push(minPoint);

            System.out.println();
        }
        return hull;
    }

    /**
     * Finds minimal point regarding current point in a group
     * @param currentPoint finds regarding this current
     * @param points group of points
     * @return minimal point
     */
    private static Point findMinimalPointGroup(Point currentPoint, Point[] points) {

        Point minPoint = points[0];

        for (int i = 1; i < points.length; i++) {

            double vectorComparator = compareTwoVectors(currentPoint, minPoint, currentPoint, points[i]);
            // if this point has less polar corner than minimal point
            if (vectorComparator < 0) {
                minPoint = points[i];
            }
            // if this point has the same polar corner but is placed farther than minimal point
            else if (vectorComparator == 0) {
                if (getLengthBetweenPoints(currentPoint, minPoint) < getLengthBetweenPoints(currentPoint, points[i])) {
                    minPoint = points[i];
                }
            }
        }

        return minPoint;
    }

    /**
     * Compares vectors a and b
     *
     * @param a1 begin point of a vector
     * @param a2 end point of a vector
     * @param b1 begin point of b vector
     * @param b2 end point of a vector
     * @return the value > 0 if a's corner is less than b's corner
     */
    private static double compareTwoVectors(Point a1, Point a2, Point b1, Point b2) {
        return (a2.getX() - a1.getX()) * (b2.getY() - b1.getY()) - (b2.getX() - b1.getX()) * (a2.getY() - a1.getY());

    }
}