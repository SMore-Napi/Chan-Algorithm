package calculation;

import elementsStructure.Point;

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
        int min = points[0].x;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < min) {
                min = points[i].x;
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
        int max = points[0].x;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x > max) {
                max = points[i].x;
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
        int min = points[0].y;
        for (int i = 1; i < points.length; i++) {
            if (points[i].y < min) {
                min = points[i].y;
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
        int max = points[0].y;
        for (int i = 1; i < points.length; i++) {
            if (points[i].y > max) {
                max = points[i].y;
            }
        }
        return max;
    }
}