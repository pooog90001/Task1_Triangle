package by.epam.vladlitvin.entity;

import by.epam.vladlitvin.action.TriangleIdAppropriater;
import by.epam.vladlitvin.observer.TriangleEvent;
import by.epam.vladlitvin.observer.TriangleObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by vlad_ on 3/17/2017.
 */
public class Triangle {
    private final static Logger LOGGER = LogManager.getLogger(Triangle.class.getName());
    private TriangleObserver observer;
    private int id;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        id = TriangleIdAppropriater.appropriateID();
    }

    public Triangle() {
        this.pointA = new Point();
        this.pointB = new Point();
        this.pointC = new Point();
        id = TriangleIdAppropriater.appropriateID();

    }

    public int getId() {
        return id;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        notifyObservers();
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        notifyObservers();
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        notifyObservers();
    }

    @Override

    public int hashCode() {
        return (int) ((pointA.hashCode() * 31) + (pointB.hashCode() * 117) + (pointC.hashCode() * 343));
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
        Triangle other = (Triangle) obj;

        if (pointA == null){
            if (other.pointA != null){
               return false;
            }
        }else if (!pointA.equals(other.pointA)){
            return false;
        }

        if (pointB == null){
            if (other.pointB != null){
                return false;
            }
        }else if (!pointB.equals(other.pointB)){
            return false;
        }

        if (pointC == null){
            if (other.pointC != null){
                return false;
            }
        }else if (!pointC.equals(other.pointC)){
            return false;
        }

        return true;

    }

    @Override
    public String toString() {
        return ("Triangle # " + id + "\n\tCoordinates of the vertex A = " + pointA.toString() +
                    "\n\tCoordinates of the vertex B = " + pointB.toString() +
                    "\n\tCoordinates of the vertex С = " + pointC.toString());
    }

    public void addObserver(TriangleObserver observer) {
        this.observer = observer;
        observer.addObservable(this);
    }

    public void removeObserver() {
        observer.removeObservable(this);
        observer = null;
    }

    private void notifyObservers() {
        if (observer != null){
            observer.handleEvent(new TriangleEvent(this));
        }
    }

}
