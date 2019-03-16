package generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RewriteSetsInOneFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "sets/set";
        PrintWriter printWriter = new PrintWriter(new File("sets/allSets.txt"));
        for (int i = 1; i <= 90; i++) {
            printWriter.println("Набор " + i + ":");
            Scanner scanner = new Scanner(new File(path + i + ".txt"));
            while(scanner.hasNext()){
                printWriter.print(scanner.nextInt() + " ");
            }
            printWriter.println();
            printWriter.println();
            scanner.close();

        }
        printWriter.close();
    }
}