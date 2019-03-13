import elementsStructure.Point;
import hull.ChanHull;
import io.Input;
import io.Output;

import java.io.IOException;
import java.util.Stack;

/**
 * Full program's work
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // Scanning and printing result of every set

        for (int i = 1; i <= 90; i++) {
            Point[] inputPoints = Input.scannerArray(i);
            Stack<Point> hull = ChanHull.toChanHull(inputPoints);
            //Output.printArray(hull, i);
        }

    }
}