package tests;

import elementsStructure.Point;
import hull.JarvisHullLonely;
import io.Input;
import io.Output;

import java.io.IOException;
import java.util.Stack;

public class TestJarvisLonelyAlgorithmMain {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 1; i++) {
            Point[] inputPoints = Input.scannerArray(i);
            Stack<Point> hull = JarvisHullLonely.getJarvisHull(inputPoints);
            Output.printStack(hull, i);
           Output.printImage(inputPoints, hull, i);
        }
    }
}