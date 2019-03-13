package hull;

import calculation.ArrayHelper;
import elementsStructure.Point;

import java.util.Stack;

import static calculation.Calculation.getLengthBetweenPoints;

public class JarvisHull {

    private static Point[] points;

    /**
     * Build the hull from input points
     *
     * @param inputPoints points which hull to build
     * @return hull
     * @throws IllegalStateException
     */
    public static Stack<Point> getJarvisHull(Point[] inputPoints) throws IllegalStateException {

        // Trows exception if count of point is less than 3
        if (inputPoints.length < 3) {
            throw new IllegalStateException("point's count is less than 3");
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
    public static Stack<Point> buildHull() {
        Stack<Point> hull = new Stack<>();

        // Finds the minimal point and places it to the end of the array
        Point firstPoint = ArrayHelper.placeMinPoint(points, points.length-1);
        Point currentPoint = firstPoint;
        hull.push(firstPoint);

        // Scans all points
        for (int i = 0; i < points.length - 1; i++) {
            Point minPoint = points[i];
            int index = i;

            // Finds the next minimal point
            for (int j = i + 1; j < points.length; j++) {
                double vectorComparator = compareTwoVectors(currentPoint, minPoint, currentPoint, points[j]);
                // if this point has less polar corner than minimal point
                if (vectorComparator < 0) {
                    minPoint = points[j];
                    index = j;
                }
                // if this point has the same polar corner but is placed farther than minimal point
                else if (vectorComparator == 0) {
                    if (getLengthBetweenPoints(currentPoint, minPoint) < getLengthBetweenPoints(currentPoint, points[j])) {
                        minPoint = points[j];
                        index = j;
                    }
                }
            }

            // Compares if the border is going to be closed
            if (!currentPoint.equals(firstPoint)) {
                if (compareTwoVectors(currentPoint, minPoint, currentPoint, firstPoint) <= 0) {
                    break;
                }
            }

            // Saves new minimal point
            currentPoint = minPoint;
            hull.push(minPoint);

            Point temp = points[i];
            points[i] = minPoint;
            points[index] = temp;
        }
        return hull;
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