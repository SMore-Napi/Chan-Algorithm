import calculation.Calculation;
import elementsStructure.Iterator;
import elementsStructure.Point;
import hull.ChanHull;
import io.Input;
import io.Output;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Full program's work
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String pathName = "results/";
        PrintWriter resultsTime = new PrintWriter(new File(pathName + "time.txt"));
        PrintWriter resultsIterations = new PrintWriter(new File(pathName + "iterations.txt"));
        PrintWriter resultsN = new PrintWriter(new File(pathName + "n.txt"));
        PrintWriter resultsH = new PrintWriter(new File(pathName + "h.txt"));

        // Scanning and printing result of every set
        for (int i = 1; i <= 90; i++) {
            Stack<Point> hull = new Stack<>();


            // Input Array
            Point[] inputPoints = Input.scannerArray(i);
            resultsN.println(inputPoints.length);

            // Input Linked List
            //LinkedList<Point> inputPoints = Input.scannerLinkedList(i);
            //resultsN.println(inputPoints.size());

            // Timing an algorithm 10 times
            for (int j = 0; j < 10; j++) {
                Iterator.setEmpty();

                long start = System.nanoTime();
                hull = ChanHull.toChanHull(inputPoints);
                long end = System.nanoTime();

                long time = end - start;
                resultsTime.print(time + " ");
            }

            resultsTime.println();
            resultsIterations.println(Iterator.get());
            resultsH.println(Calculation.getStackLength(hull));

            Output.printStack(hull, i);
        }
        resultsTime.close();
        resultsIterations.close();
        resultsN.close();
        resultsH.close();
    }
}