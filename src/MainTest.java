import elementsStructure.Point;
import hull.ChanHull;
import io.Input;
import io.Output;

import java.io.IOException;

/**
 * Test the set1
 */
public class MainTest {
    public static void main(String[] args) throws IOException {

        Point[] inputPoints = Input.scannerArray(1);
        Point[] points = ChanHull.toChanHull(inputPoints);
        Output.printArray(points, 1);
        Output.printImage(inputPoints, 1);

    }
}