import elementsStructure.Point;
import hull.ChanHull;
import io.Input;
import io.Output;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 1; i++) {
            Point[] inputPoints = Input.scannerArray(i);
            Point[] points = ChanHull.toChanHull(inputPoints);
            Output.printArray(points, i);
            Output.printImage(inputPoints, i);
        }
    }
}