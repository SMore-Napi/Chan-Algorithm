import elementsStructure.Iterator;
import elementsStructure.Point;
import hull.ChanHull;
import io.Input;
import io.Output;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * Full program's work
 */
public class Main {

    public static void main(String[] args) throws IOException {
        PrintWriter results = new PrintWriter(new File("/Users/smore/Projects/Java/Semester Project/Chan Algorithm/results.txt"));

        // Scanning and printing result of every set
        for (int i = 1; i <= 90; i++) {
            Stack<Point> hull = new Stack<>();
            // Input
            Point[] inputPoints = Input.scannerArray(i);

            results.print(inputPoints.length + " ");


            // Timing an algorithm
            long time = 0;
            for (int j = 0; j < 3; j++) {
                Iterator.setEmpty();
                long start = System.nanoTime();
                hull = ChanHull.toChanHull(inputPoints);
                long end = System.nanoTime();

                time += end - start;
            }
            time /= 3;
            results.print(time + " ");
            results.println(Iterator.get() + " ");

            Output.printStack(hull, i);


        }
        results.close();

    }
}