package hull;

import calculation.ArrayHelper;
import elementsStructure.Iterator;
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
    public static Stack<Point> getGrahamHull(Point[] inputPoints) {

        if (inputPoints.length < 3) {
            Stack<Point> hull = new Stack<>();
            for (int i = 0; i < inputPoints.length; i++) {
                hull.push(inputPoints[i]);
            }
            return hull;
        }

        points = inputPoints;

        // Finds the minimal point and places it to the end of the array
        minPoint = ArrayHelper.placeMinPoint(points, points.length - 1);

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
        rebuildLine();

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
            Iterator.plus();
            Point pNew = line.pop();
            Point pTemp = line.pop();

            // Checks if stack had two points on previous iteration
            if (line.isEmpty()) {
                line.push(pTemp);
                line.push(pNew);
                break;
            }
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
        return value > 0;
    }
}