package test.testsMain;

import elementsStructure.Point;

public class TestLeftRotateMain {
    public static void main(String[] args) {

        System.out.println(leftRotate(new Point(-5, -5), new Point(-4, -5), new Point(5,-5)));
    }
    private static double leftRotate(Point pOld, Point pTemp, Point pNew) {
        double value = (pTemp.getX() - pOld.getX()) * (pNew.getY() - pTemp.getY()) - (pTemp.getY() - pOld.getY()) * (pNew.getX() - pTemp.getX());
        return value;
    }
}
