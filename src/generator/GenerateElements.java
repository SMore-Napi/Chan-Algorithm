package generator;

import java.io.FileNotFoundException;

/**
 * Generates the sets and writes into the files
 */
public class GenerateElements {
    public static void main(String[] args) throws FileNotFoundException {
        ElementsGenerator generator = new ElementsGenerator(100, 90, 1000);
        generator.generate();
    }
}