package by.epam.vladlitvin.action;

import by.epam.vladlitvin.entity.Point;
import by.epam.vladlitvin.entity.Triangle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static by.epam.vladlitvin.action.TriangleParametersCalculater.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by vlad_ on 3/24/2017.
 */

@RunWith(Parameterized.class)
public class TriangleParametersCalculaterTest {
    private static final double NUMERICAL_INACCURACY = 0.001;
    private Triangle triangle;
    private boolean isTraingle;
    private boolean isRectangular;
    private double perimeter;
    private double square;

    public TriangleParametersCalculaterTest(Triangle triangle,
                                            boolean isTraingle,
                                            boolean isRectangular,
                                            double perimeter,
                                            double square) {
        this.triangle = triangle;
        this.isTraingle = isTraingle;
        this.isRectangular = isRectangular;
        this.perimeter = perimeter;
        this.square = square;
    }


    @Parameterized.Parameters public static Collection<Object[]> stepUpPoints(){
        return Arrays.asList( new Object[][] {
                {new Triangle(new Point(3,1), new Point(3,1),
                        new Point(3,1)), false, false, 0, 0},
                {new Triangle(new Point(3,1), new Point(3,1),
                        new Point(3,4)), false, false, 0, 0},
                {new Triangle(new Point(4,1), new Point(1,1),
                        new Point(4,5)), true, true, 12, 6},
                {new Triangle(new Point(6,1), new Point(23,41),
                        new Point(3,1)), true, false, 91.183, 59.999},
        });
    }


    @Test
    public void calculatePerimeterTest() throws Exception {

        assertThat(calculatePerimeter(triangle),
                is(closeTo(perimeter, NUMERICAL_INACCURACY)));
    }

    @Test
    public void calculateSquareTest() throws Exception {

        assertThat(calculateSquare(triangle),
                is(closeTo(square, NUMERICAL_INACCURACY)));

    }

    @Test
    public void isRectangularTest() throws Exception {

        assertThat(isRectangular(triangle), is(isRectangular));
    }

    @Test
    public void isTraingleTest() throws Exception {
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        assertThat(isTraingle(a, b, c), is(isTraingle));
    }

}