package elementsStructure;

public class Point {

    private int x; // X abscissa
    private int y; // Y ordinate
    private Integer number; // number of this point
    private boolean border; // true if point belongs to the border;

    public Point() {
        border = false;
    }

    public Point(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "[" + x + ";" + y + "]";
    }
}