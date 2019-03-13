package hull;

import elementsStructure.Point;

import java.util.Stack;

public class ChanHull {

    private static Stack<Point> hull;

    /**
     * The main algorithm
     *
     * @param inputPoints
     * @return hull
     */
    public static Stack<Point> toChanHull(Point[] inputPoints) {
        int t = 1;
        boolean isBuild = false;

        while (!isBuild) {
            int m = (int) Math.min(inputPoints.length, Math.pow(2, Math.pow(2, t)));
            isBuild = buildHull(inputPoints, m);
            t++;
        }

        return hull;
    }

    /**
     * Tries to build the hull using a parameter m
     *
     * @param m count of points in one group
     * @return hull building success
     */
    private static boolean buildHull(Point[] inputPoints, int m) {

        // Divides points on the groups
        Point[][] groups = createGroups(inputPoints, m);

        // Every group keeps only hull
        groups = setHulls(groups);

        hull = JarvisHull.getJarvisHull(groups, m);
        return hull != null;
    }

    /**
     * Every group of points array changes own values on current hull's values
     * @param inputGroups array of points
     * @return groups with hull's values
     */
    private static Point[][] setHulls(Point[][] inputGroups) {
        Point[][] groups = inputGroups;
        for (int i = 0; i < groups.length; i++) {
            Stack<Point> groupHull = GrahamHull.getGrahamHull(groups[i]);
            Point[] hullGroupArray = new Point[groups[i].length];
            int k = 0;
            while (!groupHull.isEmpty()) {
                hullGroupArray[k] = groupHull.pop();
                k++;
            }
            Point[] temp = new Point[k];
            for (int j = 0; j < k; j++) {
                temp[j] = hullGroupArray[j];
            }
            groups[i] = temp;
        }
        return groups;
    }

    /**
     * Divides input array on groups
     * @param inputPoints points to divide
     * @param m count of points in one group
     * @return two-dimensional array where each arr[i] has a group of points
     */
    private static Point[][] createGroups(Point[] inputPoints, int m) {
        int r = (int) Math.ceil((double) inputPoints.length / m);

        Point[][] groups = new Point[r][m];

        for (int i = 0; i < r; i++) {
            groups[i] = getGroup(inputPoints, i, m);
        }

        return groups;
    }

    /**
     * Returns certain group of points array
     * @param inputPoints points
     * @param groupNumber number of the group to return
     * @param m count of points in one group
     * @return array of points of the group
     */
    private static Point[] getGroup(Point[] inputPoints, int groupNumber, int m) {
        Point[] group = new Point[m];
        int k = 0;
        for (int i = groupNumber * m; i < Math.min((groupNumber + 1) * m, inputPoints.length); i++) {
            group[k] = inputPoints[i];
            k++;
        }

        if (k != m) {
            Point[] temp = new Point[k];
            for (int i = 0; i < k; i++) {
                temp[i] = group[i];
            }
            group = temp;
        }

        return group;
    }
}