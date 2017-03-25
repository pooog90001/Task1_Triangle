package by;

import by.epam.vladlitvin.action.TriangleParametersCalculaterTest;
import by.epam.vladlitvin.creator.ParameterizedPointCreatorTest;
import by.epam.vladlitvin.creator.PointCreatorTest;
import by.epam.vladlitvin.creator.TriangleCreatorTest;
import by.epam.vladlitvin.observer.TriangleObserverTest;
import by.epam.vladlitvin.reader.PointFileReaderTest;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Unit test for simple App.
 */
@Suite.SuiteClasses({ParameterizedPointCreatorTest.class,
        PointCreatorTest.class, PointFileReaderTest.class,
        TriangleParametersCalculaterTest.class, TriangleCreatorTest.class,
        TriangleObserverTest.class})

@RunWith(Suite.class)
public class AppTest extends TestCase {

}
