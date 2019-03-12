package elementsStructure;

import calculation.ArrayHelper;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class ImageFile {
    private final int SIZE_POINT = 50; // Count of pixels of which consists the point
    private Boolean[][] map; // The array keeps empty cells and points to draw on the plane
    private Point[] points;
    private int height;
    private int width;
    private int spaceY; // Y indent
    private int spaceX; // X indent
    private Stack<Point> hull;
    private BufferedImage image;

    public ImageFile(Point[] inputPoints) {
        points = inputPoints;
    }

    public ImageFile(Point[] inputPoints, Stack<Point> hull) {
        this(inputPoints);
        this.hull = hull;
    }

    /**
     * @return image to the BufferedImage
     */
    public BufferedImage toBufferedImage() {
        createImage();
        return image;
    }

    /**
     * Creates image file with drawing points
     *
     * @return
     */
    public void createImage() {
        initializeVariables();
        fillMap();
        paintAllPoints();
    }

    /**
     * Calculate class's fields
     */
    private void initializeVariables() {
        int minX = ArrayHelper.findMinX(points);
        int maxX = ArrayHelper.findMaxX(points);
        int minY = ArrayHelper.findMinY(points);
        int maxY = ArrayHelper.findMaxY(points);

        spaceY = 0; // Y indent
        spaceX = 0; // X indent

        // Image's height size
        height = maxY + 1;
        if (minY < 0) {
            spaceY = -minY;
            height += spaceY;
        }

        // Image's width size
        width = maxX + 1;
        if (minX < 0) {
            spaceX = -minX;
            width += spaceX;
        }

        initializeImageFile();
    }

    /**
     * Fills values on the map
     */
    private void fillMap() {
        // map[i][j] = true for point on the hull
        // map[i][j] = false for point inside the hull
        // map[i][j] = null for cells
        map = new Boolean[width][height];
        for (int i = 0; i < points.length; i++) {
            map[(points[i].getX()) + spaceX][(height - (points[i].getY() + spaceY) - 1)] = false;
        }

        if (hull != null) {
            while (!hull.empty()) {
                Point point = hull.pop();
                map[(point.getX()) + spaceX][(height - (point.getY() + spaceY) - 1)] = true;
            }
        }
    }

    /**
     * Creates the jpg file
     * Draws the map
     *
     * @return image file
     */
    private void initializeImageFile() {
        image = new BufferedImage((width + 2) * SIZE_POINT, (height + 2) * SIZE_POINT, BufferedImage.TYPE_INT_RGB);

        // Paints everything white
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                image.setRGB(i, j, new Color(255, 255, 255).getRGB());
            }
        }
    }

    /**
     * Paints points
     */
    private void paintAllPoints() {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (map[i][j] != null){
                    if (!map[i][j]) {
                        printArea(i, j, image, new Color(0, 0, 255));
                    } else if (map[i][j]) {
                        printArea(i, j, image, new Color(255, 0, 0));
                    }
                }
            }
        }
    }


    /**
     * Prints current cell on some image's pixels
     *
     * @param x     coordinate of cell
     * @param y     coordinate of cell
     * @param image image to color
     * @param color color to be painted
     */
    private void printArea(int x, int y, BufferedImage image, Color color) {
        for (int i = (x + 1) * SIZE_POINT; i < (x + 1) * SIZE_POINT + SIZE_POINT; i++) {
            for (int j = (y + 1) * SIZE_POINT; j < (y + 1) * SIZE_POINT + SIZE_POINT; j++) {
                image.setRGB(i, j, color.getRGB());
            }
        }
    }
}