package test.testsMain;

import calculation.Calculation;
import elementsStructure.Point;

import java.util.Stack;

public class TestStackLength {
    public static void main(String[] args) {
        Stack <Point> stack = new Stack<>();
        stack.push(new Point(6, 4));
        stack.push(new Point(2, 7));
        stack.push(new Point(1, 0));

        System.out.println(Calculation.getStackLength(stack));
        System.out.println(stack.toString());

    }
}
