package io;

import elementsStructure.ImageFile;
import elementsStructure.Point;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class Output {

    private static String pathname = "output/set";

    /**
     * Writes the output array into the file
     *
     * @param points the array to print
     * @param number the number of the set
     * @throws FileNotFoundException
     */
    public static void printArray(Point[] points, int number) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File(pathname + number + ".txt"));
        for (int i = 0; i < points.length; i++) {
            printWriter.println(points[i].toString());
        }
        printWriter.close();
    }

    public static void printStack(Stack<Point> hull, int number) throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter(new File(pathname + number + ".txt"));
        Stack<Point> hullToPrint = new Stack<>();
        hullToPrint.addAll(hull);
        while (!hullToPrint.isEmpty()) {
            printWriter.println(hullToPrint.pop().toString());
        }
        printWriter.close();
    }


    /**
     * Creates the image to show points on the plane
     *
     * @param inputPoints the points to show
     * @param number      the number of the set
     * @throws IOException
     */
    public static void printImage(Point[] inputPoints, int number) throws IOException {
        ImageFile image = new ImageFile(inputPoints);
        saveImage(image.toBufferedImage(), number);
    }

    /**
     * Creates the image to show points on the plane
     * Highlight bored points
     *
     * @param inputPoints the points to show
     * @param hull        the stack with bored points
     * @param number      the number of the set
     * @throws IOException
     */
    public static void printImage(Point[] inputPoints, Stack<Point> hull, int number) throws IOException {
        ImageFile image = new ImageFile(inputPoints, hull);
        saveImage(image.toBufferedImage(), number);
    }

    /**
     * Saves image to the file
     *
     * @param image  the image to save
     * @param number the number of the set
     * @throws IOException
     */
    private static void saveImage(BufferedImage image, int number) throws IOException {
        String pathname = "outputImage/image" + number + ".jpg";
        ImageIO.write(image, "jpg", new File(pathname));
    }
}