package calculation;

import elementsStructure.Point;

public class Sorter {
    private static Point[] helper;
    private static Point minPoint;

    /**
     * Sorts points by corner
     * Uses the merge sort
     * @param points array to sort
     * @param mainPoint point about which sorting occurs
     */
    public static void sortPointsByCorner(Point[] points, Point mainPoint) {
        minPoint = mainPoint;
        helper = new Point[points.length - 1];
        sort(points, 0, points.length - 1 - 1);
    }

    private static void sort(Point[] points, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(points, low, mid);
        sort(points, mid + 1, high);
        merge(points, low, mid, high);
    }

    private static void merge(Point[] points, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            helper[k] = points[k];
        }
        int k = low;
        while (i <= mid && j <= high) {
            // if i's corner is less than j's corner
            if (compare(helper[i], helper[j])) {
                points[k++] = helper[i++];
            } else {
                points[k++] = helper[j++];
            }
        }
        // выписываем подряд из левой части, если остались
        while (i <= mid) {
            points[k++] = helper[i++];
        }
        while (j <= high) {
            points[k++] = helper[j++];
        }
    }

    /**
     * Compares corner values of two points
     *
     * @param a first point
     * @param b scond point
     * @return true if a's corner is less than b's corner
     */
    private static boolean compare(Point a, Point b) {

        if (Calculation.getCorner(minPoint, a) < Calculation.getCorner(minPoint, b)) {
            return true;
        } else if (Calculation.getCorner(minPoint, a) == Calculation.getCorner(minPoint, b)) {
            return (a.getX() < b.getX());
        } else {
            return false;
        }
    }
}