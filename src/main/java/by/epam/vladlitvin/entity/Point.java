package by.epam.vladlitvin.entity;

/**
 * Created by vlad_ on 3/17/2017.
 */
public class Point {

    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return (int) ((31*y) + (x*117));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }
        Point other = (Point) obj;

        if(other.x != this.x){
            return false;
        }
        if(other.y != this.y){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }

}
