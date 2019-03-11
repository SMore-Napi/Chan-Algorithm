package calculation;

import elementsStructure.Point;

public class Calculation {
    /**
     * Calculates the corner between two points
     *
     * @param a first point
     * @param b second point
     * @return value of the corner
     */
    public static double getCorner(Point a, Point b) {
        double y = b.y - a.y;
        double x = b.x - a.x;

        return Math.atan2(y, x);
    }

    /**
     * Randomise the number between [l;r]
     *
     * @param l left border
     * @param r right border
     * @return number in the [l;r] range
     */
    public static int getRandomInRange(int l, int r) {
        return (int) (Math.random() * (r + 1 - l)) + l;
    }

    /**
     * Randomise the number
     *
     * @param maxValue max value to randomise
     * @return random number
     */
    public static int getRandomNumber(int maxValue) {
        //  Randomise the value
        int value = (int) (Math.random() * maxValue);

        // Randomise the sign
        int sign = (int) (Math.random() * 2);
        if (sign == 1) {
            value = -value;
        }

        return value;
    }
}