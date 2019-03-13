package tests;

import elementsStructure.Point;
import hull.ChanHull;
import io.Input;
import io.Output;

import java.io.IOException;
import java.util.Stack;

/**
 * Test the set1
 */
public class TestChanAlgorithmMain {
    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 90; i++) {
            Point[] inputPoints = Input.scannerArray(i);
            Stack<Point> hull = ChanHull.toChanHull(inputPoints);
            Output.printStack(hull, i);
            //Output.printImage(inputPoints, hull, i);
        }
    }
}