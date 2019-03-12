package hull;

import elementsStructure.Point;

import java.util.Stack;

import static calculation.Sorter.sortPointsByCorner;

public class GrahamHull {

    private static Point minPoint;
    private static Point[] points;
    private static Stack<Point> line = new Stack<>();

    /**
     * Build the hull from input points
     *
     * @param inputPoints points which hull to build
     * @return hull
     * @throws IllegalStateException
     */
    public static Stack<Point> getGrahamHull(Point[] inputPoints) throws IllegalStateException {

        // Trows exception if count of point is less than 3
        if (inputPoints.length < 3) {
            throw new IllegalStateException("point's count is less than 3");
        }

        points = inputPoints;

        // Finds the minimal point
        minPoint = findLeftElement();

        // Sorts other points relatively the minimal point
        sortPointsByCorner(points, minPoint);

        // Build and return the hull
        return buildHull();
    }

    /**
     * Builds the hull
     *
     * @return array of points which are belong to the hull's boarder
     */
    private static Stack<Point> buildHull() {

        line = new Stack<>();

        // Pushes the minimal point
        line.push(points[points.length - 1]);

        // Pushes two first points
        line.push(points[0]);
        line.push(points[1]);

        for (int i = 2; i < points.length - 1; i++) {
            line.push(points[i]);
            rebuildLine();
        }

        return line;
    }

    /**
     * Checks if the hull is correct
     */
    private static void rebuildLine() {
        boolean changed;

        do {
            Point pNew = line.pop();
            Point pTemp = line.pop();
            Point pOld = line.peek();

            if (!isLeftRotate(pOld, pTemp, pNew)) {
                line.push(pNew);
                changed = true;
            } else {
                line.push(pTemp);
                line.push(pNew);
                changed = false;
            }
        }
        while (changed);
    }

    /**
     * Checks if the direction of three points is counterclock-wise
     *
     * @param pOld  the main point
     * @param pTemp the point between the main and new added point
     * @param pNew  the new added point
     * @return true if the direction is correct
     */
    private static boolean isLeftRotate(Point pOld, Point pTemp, Point pNew) {
        double value = (pTemp.getX() - pOld.getX()) * (pNew.getY() - pTemp.getY()) - (pTemp.getY() - pOld.getY()) * (pNew.getX() - pTemp.getX());
        if (value >= 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Finds the minimal element which is to the left and below others
     *
     * @return the minimal point
     */
    private static Point findLeftElement() {
        Point minPoint = new Point(points[0].getX(), points[0].getY());
        int index = 0;
        for (int i = 1; i < points.length; i++) {
            if ((points[i].getX() < minPoint.getX()) || ((points[i].getX() == minPoint.getX()) && (points[i].getY() < minPoint.getY()))) {
                minPoint.setX(points[i].getX());
                minPoint.setY(points[i].getY());
                index = i;
            }
        }

        // Places the minimal point to the end of array
        Point temp = points[points.length - 1];
        points[points.length - 1] = minPoint;
        points[index] = temp;

        return minPoint;
    }
}