package generator;

import calculation.Calculation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ElementsGenerator {

    private int stepCountElem; // The value of increasing count of elements
    private int countSets; // Count of sets
    private int maxValue; // Count of sets
    private String pathName;
    private int number; // The number of the current set

    public ElementsGenerator(int stepCountElem, int countSets, int maxValue) {
        pathName = "sets/set";
        number = 1;

        this.stepCountElem = stepCountElem;
        this.countSets = countSets;
        this.maxValue = maxValue;
    }

    /**
     * Generate sets
     *
     * @throws FileNotFoundException
     */
    public void generate() throws FileNotFoundException {
        for (int i = stepCountElem; i <= stepCountElem * countSets; i += stepCountElem) {
            generateSet(i);
            number++;
        }
    }

    /**
     * Generate the set
     *
     * @param countElem the count of elements in the set
     * @throws FileNotFoundException
     */
    private void generateSet(int countElem) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File(pathName + number + ".txt"));

        for (int i = 0; i < countElem; i++) {
            // generate the element's value (-MAX_VALUE; MAX_VALUE)
            int value = Calculation.getRandomNumber(maxValue);
            printWriter.print(value + " ");
        }

        printWriter.close();
    }
}