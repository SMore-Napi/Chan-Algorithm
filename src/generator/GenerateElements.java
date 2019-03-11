package generator;

import java.io.FileNotFoundException;

public class GenerateElements {
    public static void main(String[] args) throws FileNotFoundException {
        ElementsGenerator generator = new ElementsGenerator();
        generator.generate();
    }
}