package elementsStructure;

public class Iterator {
    private static long iterator = 0;

    public static void plus(){
        iterator++;
    }

    public static long get(){
        return iterator;
    }

    public static void setEmpty() {
        iterator = 0;
    }
}
