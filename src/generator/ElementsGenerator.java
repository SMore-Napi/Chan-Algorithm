package generator;

import calculation.Calculation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ElementsGenerator {

    private final int STEP_COUNT_ELEM = 100; // The value of increasing count of elements
    private final int COUNT_SETS = 90; // Count of sets
    private String pathName;
    private int number; // The number of the current set

    public ElementsGenerator() {
        pathName = "/Users/smore/Projects/Java/Semester Project/Chan Algorithm/sets/set";
        number = 1;
    }

    /**
     * Generate sets
     *
     * @throws FileNotFoundException
     */
    public void generate() throws FileNotFoundException {
        for (int i = STEP_COUNT_ELEM; i <= STEP_COUNT_ELEM * COUNT_SETS; i += STEP_COUNT_ELEM) {
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
            // generate the element's value (-1000; 1000)
            int value = Calculation.getRandomNumber(1000);
            printWriter.print(value + " ");
        }

        printWriter.close();
    }
}