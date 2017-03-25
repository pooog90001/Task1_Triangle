package by.epam.vladlitvin.observer;

import by.epam.vladlitvin.entity.Point;
import by.epam.vladlitvin.entity.Triangle;
import by.epam.vladlitvin.exception.PerameterCloneException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by vlad_ on 3/19/2017.
 */

public class TriangleObserverTest {
    private Triangle triangle1;
    private Triangle triangle2;
    private Triangle triangle3;
    private TriangleObserver observer;

    @Before
    public void setUp() {
        triangle1 = new Triangle(new Point(23, 32),
                new Point(2, 12), new Point(24, 31));
        triangle2 = new Triangle(new Point(4, 3.2),
                new Point(2, 172), new Point(4, 34));
        triangle3 = new Triangle(new Point(23, 32),
                new Point(2, 3), new Point(64, 309));
        observer = new TriangleObserver();
    }

    @Test
    public void observerTest1() throws PerameterCloneException {
        triangle1.addObserver(observer);
        triangle2.addObserver(observer);
        triangle2.removeObserver();
        assertThat(observer.getParameter(triangle2), is(nullValue()));
    }

    @Test
    public void observerTest2() throws PerameterCloneException {
        triangle1.addObserver(observer);
        assertThat(observer.getParameter(triangle1), is(notNullValue()));
    }

    @Test
    public void observerTest3() throws PerameterCloneException {
        triangle1.addObserver(observer);
        Object expected = observer.getParameter(triangle1);
        triangle1.setPointA(new Point(0, 0));
        assertThat(observer.getParameter(triangle1), not(equalTo(expected)));
    }

}