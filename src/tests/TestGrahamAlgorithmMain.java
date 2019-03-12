package tests;

import elementsStructure.Point;
import hull.GrahamHull;
import io.Input;
import io.Output;

import java.io.IOException;
import java.util.Stack;

public class TestGrahamAlgorithmMain {
    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 90; i++) {
            Point[] inputPoints = Input.scannerArray(i);
            Stack<Point> hull = GrahamHull.getGrahamHull(inputPoints);
            Output.printStack(hull, i);
            //Output.printImage(inputPoints, hull, i);
        }

    }
}