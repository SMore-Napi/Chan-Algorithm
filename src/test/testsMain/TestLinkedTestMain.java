package test.testsMain;

import elementsStructure.Point;

import java.util.LinkedList;

public class TestLinkedTestMain {
    public static void main(String[] args) {
        LinkedList<Point> list = new LinkedList<>();
        list.add(new Point(0,1));
        list.add(new Point(4,3));
        list.add(new Point(-2,6));

        Point [] array = new Point[list.size()];
        int k = 0;
        while(!list.isEmpty()){
            array[k] = list.pop();
            k++;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
