import elementsStructure.Point;
import hull.ChanHull;
import io.Input;
import io.Output;

import java.io.IOException;

/**
 * Full program's work
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // Scanning and printing result of every set
        for (int i = 1; i <= 90; i++) {
            Point[] inputPoints = Input.scannerArray(i);
            Point[] pointsResult = ChanHull.toChanHull(inputPoints);
            Output.printArray(pointsResult, i);
        }
    }
}