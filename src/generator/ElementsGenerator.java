package generator;

import calculation.Calculation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ElementsGenerator {
    private final int STEP_COUNT_ELEM = 100;
    private final int COUNT_SETS = 90;
    private String pathName;
    private int number;

    public ElementsGenerator() {
        pathName = "/Users/smore/Projects/Java/Semester Project/Chan Algorithm/sets/set";
        number = 1;
    }

    public void generate() throws FileNotFoundException {
        for (int i = STEP_COUNT_ELEM; i <= STEP_COUNT_ELEM * COUNT_SETS; i += STEP_COUNT_ELEM) {
            generateSet(i);
            number++;
        }
    }

    private void generateSet(int countElem) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File(pathName + number + ".txt"));

        for (int i = 0; i < countElem; i++) {
            int value = Calculation.getRandomNumber(1000);
            printWriter.print(value + " ");
        }
        printWriter.close();
    }
}