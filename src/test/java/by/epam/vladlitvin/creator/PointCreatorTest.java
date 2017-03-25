package by.epam.vladlitvin.creator;

import by.epam.vladlitvin.entity.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by vlad_ on 3/22/2017.
 */
public class PointCreatorTest {

    private ArrayList<Point> expectedList;
    private String string;

    @Before
    public void beforTest(){
        expectedList = new ArrayList<Point>();
        string = new String();
    }

    @Test
    public void createPoints1() throws Exception {
        string = "(12, 01) (1.2, 61) (343532.982422, 0) (2.9824 22, 00000.0000) sdfwecscsad(12, 01)324235325";
        ArrayList<Point> pointArray = PointCreator.createPoints(string);

        expectedList.add(new Point(12,1));
        expectedList.add(new Point(1.2,61));
        expectedList.add(new Point(343532.982422,0));
        expectedList.add(new Point(12,1));
        assertEquals(expectedList, pointArray);
    }

    @Test
    public void createPoints2() throws Exception {
        string = "(12sada, 01) (1.1231231231231232, 61) (343532.982422, 0) " +
                "(2.9824 22, 00000.0000) sdfwecscsad(12, 01)324235325";
        ArrayList<Point> pointArray = PointCreator.createPoints(string);

        expectedList.add(new Point(12,1));
        expectedList.add(new Point(1.2,61));
        expectedList.add(new Point(343532.982422,0));
        expectedList.add(new Point(12,1));

        assertNotEquals(expectedList, pointArray);
    }

}