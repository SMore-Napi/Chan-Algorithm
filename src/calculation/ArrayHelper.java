package calculation;

import elementsStructure.Point;

import java.util.Stack;

/**
 * This class contains static calculation methods for the array
 */
public class ArrayHelper {

    /**
     * Extends the range of array
     * @param points the array to extend
     * @return array with length = 1.5 * length
     */
    public static Point[] extendArray(Point[] points) {
        Point[] newArray = new Point[points.length + (points.length >> 1)];
        for (int i = 0; i < points.length; i++) {
            newArray[i] = points[i];
        }

        return newArray;
    }

    /**
     * Finds a point with minimal X value
     * @param points array for finding point
     * @return point with minimal X value
     */
    public static int findMinX(Point[] points) {
        int min = points[0].getX();
        for (int i = 1; i < points.length; i++) {
            if (points[i].getX() < min) {
                min = points[i].getX();
            }
        }
        return min;
    }

    /**
     * Finds a point with maximal X value
     * @param points array for finding point
     * @return point with maximal X value
     */
    public static int findMaxX(Point[] points) {
        int max = points[0].getX();
        for (int i = 1; i < points.length; i++) {
            if (points[i].getX() > max) {
                max = points[i].getX();
            }
        }
        return max;
    }

    /**
     * Finds a point with minimal Y value
     * @param points array for finding point
     * @return point with minimal Y value
     */
    public static int findMinY(Point[] points) {
        int min = points[0].getY();
        for (int i = 1; i < points.length; i++) {
            if (points[i].getY() < min) {
                min = points[i].getY();
            }
        }
        return min;
    }

    /**
     * Finds a point with maximal Y value
     * @param points array for finding point
     * @return point with maximal Y value
     */
    public static int findMaxY(Point[] points) {
        int max = points[0].getY();
        for (int i = 1; i < points.length; i++) {
            if (points[i].getY() > max) {
                max = points[i].getY();
            }
        }
        return max;
    }
}