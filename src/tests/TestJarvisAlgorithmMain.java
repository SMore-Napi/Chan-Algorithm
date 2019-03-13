package tests;

import elementsStructure.Point;
import hull.JarvisHull;
import io.Input;
import io.Output;

import java.io.IOException;
import java.util.Stack;

public class TestJarvisAlgorithmMain {
    public static void main(String[] args) throws IOException {
        for (int i = 2; i <= 2; i++) {
            Point[] inputPoints = Input.scannerArray(i);
            Stack<Point> hull = JarvisHull.getJarvisHull(inputPoints);
            Output.printStack(hull, i);
           Output.printImage(inputPoints, hull, i);
        }
    }
}