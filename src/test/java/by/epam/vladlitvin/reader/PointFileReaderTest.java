package by.epam.vladlitvin.reader;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;


import static org.junit.Assert.*;

/**
 * Created by vlad_ on 3/19/2017.
 */
public class PointFileReaderTest {
    private ArrayList<String> list;
    //private PointFileReader reader = Mockito.mock(PointFileReader.class);


    @Before
    public void setUp() {
        list = new ArrayList<String>();
    }

    @Test(expected = RuntimeException.class)
    public void wrongRead() throws Exception {
        list = PointFileReader.readFile("sdfsdf");
        assertThat(list, is(nullValue()));
    }
    @Test
    public void rightRead() throws Exception {
        list = PointFileReader.readFile("resources\\inPutFile.txt");
        assertThat(list, hasSize(5));
    }

    @Test
    public void rightReadTwoo() throws Exception {
        ArrayList<String> expectedList = new ArrayList<String>(){{
            add("(12, 01), (12, 03.2), (03.3, 2);");
            add("x = -32; y = 3;");
            add("x = 123, 322; y = 32.34;");
            add("x = 123, 322; 2y =23 32.34;");
            add("x = 123; y = 32.34;");
        }};
        ArrayList<String> list = PointFileReader.readFile("resources\\inPutFile.txt");
        assertThat(list, hasSize(5));
    }

    @Test
    public void rightReadThree() throws Exception {
        ArrayList<String> expectedList = new ArrayList<String>() {{
            add("(12, 01), (12, 03.2), (03.3, 2);");
            add("(12, 01), (12, 0sd3.2), (03.3, 2);");
            add("(12, 01333333333), (12, 03.2), (03.3, 2);");
            add("(12, 01), (12, 03.2), (03.3, 2);");
            add("(12, 01), (12, 03.2), (03.3, 2);");
        }};
        ArrayList<String> list = PointFileReader.readFile("resources\\inPutFile.txt");
        assertThat(list, equalTo(expectedList));
    }

}