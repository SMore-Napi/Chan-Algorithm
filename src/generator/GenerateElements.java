package generator;

import java.io.FileNotFoundException;

/**
 * Generates the sets and writes into the files
 */
public class GenerateElements {
    public static void main(String[] args) throws FileNotFoundException {
        ElementsGenerator generator = new ElementsGenerator(200, 90, 1000000);
        generator.generate();
    }
}