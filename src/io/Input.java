package io;

import calculation.ArrayHelper;
import elementsStructure.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Input {

    private static String pathName = "sets/set";

    /**
     * Reads from the file the current set
     *
     * @param setNumber number of the set
     * @return the array of the points
     * @throws FileNotFoundException
     */
    public static Point[] scannerArray(int setNumber) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(pathName + setNumber + ".txt"));
        Point[] points = new Point[10];
        int iPoint = 0;

        while (scanner.hasNext()) {

            Point point = new Point();
            point.setX(scanner.nextInt());
            point.setY(scanner.nextInt());

            // Extends the array if it is full
            if (iPoint == points.length) {
                points = ArrayHelper.extendArray(points);
            }

            points[iPoint++] = point;
        }

        // Creating the array with valid length
        Point[] arrayToReturn = new Point[iPoint];
        for (int i = 0; i < arrayToReturn.length; i++) {
            arrayToReturn[i] = points[i];
        }
        return arrayToReturn;
    }

    public static LinkedList<Point> scannerLinkedList(int setNumber) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(pathName + setNumber + ".txt"));

        LinkedList<Point> points = new LinkedList<>();

        while (scanner.hasNext()) {

            Point point = new Point();
            point.setX(scanner.nextInt());
            point.setY(scanner.nextInt());

            points.add(point);
        }

        return points;
    }
}