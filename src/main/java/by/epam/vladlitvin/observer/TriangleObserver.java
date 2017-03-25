package by.epam.vladlitvin.observer;


import by.epam.vladlitvin.entity.Triangle;
import by.epam.vladlitvin.exception.PerameterCloneException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import static by.epam.vladlitvin.action.TriangleParametersCalculater.*;


/**
 * Created by vlad_ on 3/19/2017.
 */
public class TriangleObserver implements Observer {
    private final static Logger LOGGER = LogManager.getLogger(Triangle.class.getName());

    private HashMap<Integer,PerimeterAndSquare> parametersMap;

    public TriangleObserver() {
        parametersMap = new HashMap<>();
    }

    public  PerimeterAndSquare getParameter(Triangle triangle) throws PerameterCloneException {
        int id = triangle.getId();
        if (parametersMap.containsKey(id)) {
            PerimeterAndSquare parameter = parametersMap.get(id);
            try {
                return (PerimeterAndSquare) parameter.clone();

            } catch (CloneNotSupportedException e) {
                LOGGER.log(Level.ERROR,"Error do PerimeterAndSquare copy" + e);
                throw new PerameterCloneException("Can't do copy", e);
            }
        } else {
            return null;
        }
    }

    public void addObservable(Triangle triangle) {
        int id =  triangle.getId();
        double perimeter = calculatePerimeter(triangle);
        double square = calculateSquare(triangle);
        PerimeterAndSquare perimeterAndSquare =
                new PerimeterAndSquare(square, perimeter);
        parametersMap.put(id, perimeterAndSquare);
        LOGGER.info("Observer added " + triangle.toString());
        LOGGER.log(Level.INFO, perimeterAndSquare.toString());
    }

    public void removeObservable(Triangle triangle) {
        int id = triangle.getId();
        parametersMap.remove(id);
        LOGGER.log(Level.INFO,"Triangle with id: " + id +
                " removed");
    }

    public void handleEvent(TriangleEvent event) {
        Triangle triangle = event.getSource();
        int id  = triangle.getId();
        double perimeter = calculatePerimeter(triangle);
        double square = calculateSquare(triangle);
        PerimeterAndSquare perimeterAndSquare = parametersMap.get(id);
        perimeterAndSquare.setSquare(square);
        perimeterAndSquare.setPerimeter(perimeter);
        LOGGER.log(Level.INFO,"Changed "+ triangle.toString());
        LOGGER.log(Level.INFO, perimeterAndSquare.toString());
    }



    private class PerimeterAndSquare implements Cloneable {
        private double square;
        private double perimeter;

        public PerimeterAndSquare(double square, double perimeter) {
            this.square = square;
            this.perimeter = perimeter;
        }

        public double getSquare() {
            return square;
        }

        public void setSquare(double square) {
            this.square = square;
        }

        public double getPerimeter() {
            return perimeter;
        }

        public void setPerimeter(double perimeter) {
            this.perimeter = perimeter;
        }

        @Override
        public int hashCode() {
            return (int) ((31*perimeter) + (square*117));

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
            PerimeterAndSquare other = (PerimeterAndSquare) obj;

            if(other.square != this.square) {
                return false;
            }
            if(other.perimeter != this.perimeter){
                return false;
            }
            return true;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return ("Square = " + square + " perimeter = " + perimeter);
        }
    }
}
