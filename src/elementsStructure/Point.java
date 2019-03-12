package elementsStructure;

public class Point {

    private int x; // X abscissa
    private int y; // Y ordinate

    public Point() {

    }

    public Point(int x, int y) {
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

    @Override
    public String toString() {
        return "[" + x + ";" + y + "]";
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Point)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Point p = (Point) obj;
        return this.getX() == p.getX() &&
                this.getY() == p.getY();
    }
}