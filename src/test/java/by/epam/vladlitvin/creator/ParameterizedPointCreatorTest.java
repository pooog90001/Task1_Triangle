package by.epam.vladlitvin.creator;

import by.epam.vladlitvin.entity.Point;
import by.epam.vladlitvin.creator.PointCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by vlad_ on 3/22/2017.
 */

@RunWith(Parameterized.class)
public class ParameterizedPointCreatorTest {
    private String line;
    private Point point;

    public ParameterizedPointCreatorTest(String line, Point point) {
        this.line = line;
        this.point = point;
    }

    @Parameterized.Parameters public static Collection<Object[]> stepUpPoints(){
        return Arrays.asList( new Object[][] {
            {"(12, 01)", new Point(12,1)},
            {"(1.2, 61)", new Point(1.2,61)},
            {"(343532.982422, 0)", new Point(343532.982422,0)},
            {"(2.982422, 00000.0000)", new Point(2.982422,0)},
            {"sdfwecscsad(12, 01)324235325", new Point(12,1)},
            {"(12323.233223, 223233.232301)", new Point(12323.233223,223233.232301)},
            {"(000012, 01)", new Point(12,1)},
            {"(0, 0.00002)", new Point(0,0.00002)}
        });
    }

    @Test
    public void createPoint() throws Exception {
        Point expected = this.point;
        Point point = PointCreator.createPoint(this.line);
        assertEquals(expected, point);
    }
}
