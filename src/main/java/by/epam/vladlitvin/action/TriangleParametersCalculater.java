package by.epam.vladlitvin.action;

import by.epam.vladlitvin.entity.Point;
import by.epam.vladlitvin.entity.Triangle;

import static java.lang.Math.abs;
import static java.lang.Math.hypot;
import static java.lang.Math.sqrt;

/**
 * Created by vlad_ on 3/22/2017.
 */
public class TriangleParametersCalculater {

    public static double calculatePerimeter(Triangle triangle){
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        if (isTraingle(a, b, c)) {
            double sideA = calculateSide(a, b);
            double sideB = calculateSide(b, c);
            double sideC = calculateSide(c, a);
            return (sideA + sideB + sideC);
        }
        return 0;
    }

    public static double calculateSquare(Triangle triangle) {
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        if (isTraingle(a, b, c)) {
            double sideA = calculateSide(a, b);
            double sideB = calculateSide(b, c);
            double sideC = calculateSide(c, a);
            double halfPerimenter = calculatePerimeter(triangle) / 2;
            sideA = halfPerimenter - sideA;
            sideB = halfPerimenter - sideB;
            sideC = halfPerimenter - sideC;
            double square = sqrt(halfPerimenter * sideA * sideB * sideC);
            return square;
        }
        return 0;
    }

    private static double calculateSide(Point pointA, Point pointB) {
        double catheterOne = abs(pointA.getX() - pointB.getX());
        double catheterTwo = abs(pointA.getY() - pointB.getY());
        return hypot(catheterOne, catheterTwo);
    }

    public static boolean isRectangular(Triangle triangle){
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        if(isTraingle(a, b, c)) {
            double sideA = calculateSide(a, b);
            double sideB = calculateSide(b, c);
            double sideC = calculateSide(c, a);
            double square = calculateSquare(triangle);
            if (square == (sideA * sideB * 0.5)) {
                return true;
            }
            if (square == (sideA * sideC * 0.5)) {
                return true;
            }
            if (square == (sideC * sideB * 0.5)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isTraingle(Point a, Point b, Point c){
        if ((a.getX() == b.getX()) && (c.getX() == b.getX())) {
            return false;
        }
        if ((a.getY() == b.getY()) && (c.getY() == b.getY())) {
            return false;
        }
        return true;
    }
}
