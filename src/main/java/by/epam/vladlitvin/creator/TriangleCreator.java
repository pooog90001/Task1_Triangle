package by.epam.vladlitvin.creator;

import by.epam.vladlitvin.entity.Point;
import by.epam.vladlitvin.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by vlad_ on 3/18/2017.
 */
public class TriangleCreator {
    private final static Logger LOGGER = LogManager.getLogger(TriangleCreator.class.getName());
    private final static String POINT_REGEX = "\\((\\d{1,6})(\\.\\d{1,6})?," +
            "\\p{Space}(\\d{1,6})(\\.\\d{1,6})?\\)";
    private final static String TRAINGLE_REGEX = "\\p{Space}*" + POINT_REGEX + ",\\p{Space}" +
            POINT_REGEX + ",\\p{Space}" + POINT_REGEX +";\\p{Space}*";

    public static Triangle createTraingle(String inPut) {
        Pattern patternTraingle = Pattern.compile(TRAINGLE_REGEX);
        Matcher matcher = patternTraingle.matcher(inPut);
        ArrayList<Point> listPoints = new ArrayList<Point>();

        if(matcher.find()) {
            listPoints = PointCreator.createPoints(matcher.group());
            Point pointA = listPoints.get(0);
            Point pointB = listPoints.get(1);
            Point pointC = listPoints.get(2);
            return new Triangle(pointA, pointB, pointC);
        } else {
            LOGGER.log(Level.WARN, "Mistake created traingle " + inPut);
            return null;
        }

    }

    public static ArrayList<Triangle> createTraingles(ArrayList<String> listStrings) {
        ArrayList<Triangle> listTriangles = new ArrayList<Triangle>();
        Pattern patternTraingle = Pattern.compile(TRAINGLE_REGEX);

        for (String line : listStrings) {
            Matcher matcher = patternTraingle.matcher(line);

            while (matcher.find()) {
                listTriangles.add(createTraingle(matcher.group()));
            }
        }
        LOGGER.log(Level.INFO, "Created " + listTriangles.size() + " traingles \n\t "
                + listTriangles.toString());
        return listTriangles;

    }
}
