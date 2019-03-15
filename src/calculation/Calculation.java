package calculation;

import elementsStructure.Point;

import java.util.Stack;

public class Calculation {
    /**
     * Calculates the corner between two points
     *
     * @param a first point
     * @param b second point
     * @return value of the corner
     */
    public static double getCorner(Point a, Point b) {
        double y = b.getY() - a.getY();
        double x = b.getX() - a.getX();

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

    public static double getLengthBetweenPoints(Point a, Point b){
        return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
    }

    public static long getStackLength(Stack stack){
        Stack x = (Stack)stack.clone();
        long length = 0;
        while(!x.isEmpty()){
            x.pop();
            length++;
        }
        return length;
    }
}