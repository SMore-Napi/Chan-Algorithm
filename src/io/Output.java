package io;

import calculation.ArrayHelper;
import elementsStructure.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Output {

    private static String pathname = "/Users/smore/Projects/Java/Semester Project/Chan Algorithm/output/set";
    private final static int SIZE_POINT = 50; // Count of pixels of which consists the point

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

    /**
     * Creates the image to show points on the plane
     *
     * @param points the points to show
     * @param number the number of the set
     * @throws IOException
     */
    public static void printImage(Point[] points, int number) throws IOException {

        String pathname = "/Users/smore/Projects/Java/Semester Project/Chan Algorithm/outputImage/image" + number + ".jpg";


        int minX = ArrayHelper.findMinX(points);
        int maxX = ArrayHelper.findMaxX(points);
        int minY = ArrayHelper.findMinY(points);
        int maxY = ArrayHelper.findMaxY(points);

        int spaceY = 0; // Y indent
        int spaceX = 0; // X indent

        // Image's height size
        int height = maxY + 1;
        if (minY < 0) {
            spaceY = -minY;
            height += spaceY;

        }

        // Image's width size
        int width = maxX + 1;
        if (minX < 0) {
            spaceX = -minX;
            width += spaceX;
        }


        // The array keeps empty cells and points to draw on the plane
        // map[i][j] = true for point
        // map[i][j] = false for cells
        boolean[][] map = new boolean[width][height];

        for (int i = 0; i < points.length; i++) {
            map[(points[i].x) + spaceX][(height - (points[i].y + spaceY) - 1)] = true;
        }

        // Creates the jpg file. Draws the map
        BufferedImage image = new BufferedImage((width + 2) * SIZE_POINT, (height + 2) * SIZE_POINT, BufferedImage.TYPE_INT_RGB);

        // Paints everything white
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                image.setRGB(i, j, new Color(255, 255, 255).getRGB());
            }
        }

        // Paints points
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (map[i][j]) {
                    printArea(i, j, image, new Color(255, 0, 0));
                }
            }
        }

        ImageIO.write(image, "jpg", new File(pathname));
    }

    // Prints current cell on some image's pixels
    private static void printArea(int x, int y, BufferedImage image, Color color) {
        for (int i = (x + 1) * SIZE_POINT; i < (x + 1) * SIZE_POINT + SIZE_POINT; i++) {
            for (int j = (y + 1) * SIZE_POINT; j < (y + 1) * SIZE_POINT + SIZE_POINT; j++) {
                image.setRGB(i, j, color.getRGB());
            }
        }
    }
}