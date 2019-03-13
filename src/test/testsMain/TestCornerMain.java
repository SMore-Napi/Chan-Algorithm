package test.testsMain;

import calculation.Calculation;
import elementsStructure.Point;

public class TestCornerMain {
    public static void main(String[] args) {

        Point a = new Point(0, 0);
        Point b = new Point(1, -5);
        Point c = new Point(3, -3);
        Point d = new Point(3, 1);
        Point e = new Point(3, 3);
        Point f = new Point(6, 6);
        Point g = new Point(1, 4);
        Point h = new Point(0, 6);

        System.out.println(Calculation.getCorner(a, b));
        System.out.println(Calculation.getCorner(a, c));
        System.out.println(Calculation.getCorner(a, d));
        System.out.println(Calculation.getCorner(a, e));
        System.out.println(Calculation.getCorner(a, f));
        System.out.println(Calculation.getCorner(a, g));
        System.out.println(Calculation.getCorner(a, h));




    }
}
