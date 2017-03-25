package by.epam.vladlitvin.creator;

import by.epam.vladlitvin.entity.Point;
import by.epam.vladlitvin.entity.Triangle;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

import static org.junit.Assert.*;

/**
 * Created by vlad_ on 3/21/2017.
 */
public class TriangleCreatorTest {
    private Triangle triangle;
    private ArrayList<Triangle> trianglesList;
    private ArrayList<String> stringsList;
    @Before
    public void setUp() {
        triangle = new Triangle();
        stringsList = new ArrayList<String>(){{
            add("(12, 01), (12, 03.2), (03.3, 2);");
            add("(12, 01), (12, 0sd3.2), (03.3, 2);");
            add("(12, 01333333333), (12, 03.2), (03.3, 2);");
            add("(12, 01), (12, 03.2), (03.3, 2);");
            add("(12, 01), (12, 03.2), (03.3, 2);");
        }};
        trianglesList = new ArrayList<>();
    }

    @Test
    public void createTriangle1() throws Exception {
        triangle =  TriangleCreator.createTraingle("weerrerewree");
        assertThat(triangle, is(nullValue()));
    }

    @Test
    public void createTriangle2() throws Exception {
        triangle = TriangleCreator.createTraingle("(12, 01 ),  (12, 03.2), (03.3, 2);");
        assertThat(triangle, is(nullValue())) ;
    }

    @Test
    public void createTriangle3() throws Exception {
        triangle = TriangleCreator.createTraingle("(12, 01), (12, 03.2), (03.3, 2);");
        Triangle expected = new Triangle(){{
            setPointA(new Point(12, 1));
            setPointB(new Point(12, 3.2));
            setPointC(new Point(3.3, 2));
        }};
        assertThat(triangle.getPointA(), is(expected.getPointA()));
    }

    @Test
    public void createTriangles1() throws Exception {
        trianglesList = TriangleCreator.createTraingles(stringsList);
        assertThat(trianglesList, hasSize(3));
    }

    @Test
    public void createTriangles2() throws Exception {
        stringsList = new ArrayList<String>();
        trianglesList = TriangleCreator.createTraingles(stringsList);
        assertThat(trianglesList, hasSize(0));
    }


}