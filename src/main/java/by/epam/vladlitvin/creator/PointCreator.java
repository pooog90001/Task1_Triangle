package by.epam.vladlitvin.creator;



import by.epam.vladlitvin.entity.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vlad_ on 3/18/2017.
 */
public class PointCreator {
    private final static Logger LOGGER = LogManager.getLogger(PointCreator.class.getName());
    private final static String NUMBER_REGEX = "(\\d{1,6})(\\.\\d{1,6})?";
    private final static String POINT_REGEX = "\\((\\d{1,6})(\\.\\d{1,6})?,\\p{Space}" +
            "(\\d{1,6})(\\.\\d{1,6})?\\)";

    public static ArrayList<Point> createPoints(ArrayList<String> listStrings) {
        ArrayList<Point> listPoints = new ArrayList<Point>();
        Pattern pattern = Pattern.compile(POINT_REGEX);

        for (String line : listStrings) {
            Matcher matcher = pattern.matcher(line);
            Point point = new Point();

            while (matcher.find()) {
                listPoints.add(createPoint(matcher.group()));
            }
        }
        LOGGER.info("Created " + listPoints.size() + " points \n\t "
                + listPoints.toString());
        return listPoints;
    }

    public static ArrayList<Point> createPoints(String inPut) {
        ArrayList<Point> listPoints = new ArrayList<Point>();
        Pattern pattern = Pattern.compile(POINT_REGEX);
        Matcher matcher = pattern.matcher(inPut);
        Point point = new Point();

        while (matcher.find()) {
            listPoints.add(createPoint(matcher.group()));
        }
        LOGGER.info("Created " + listPoints.size() + " points \n\t "
                + listPoints.toString());
        return listPoints;
    }

    public static Point createPoint(String inPut) {
        Pattern patternPoint = Pattern.compile(POINT_REGEX);
        Pattern patternNumber = Pattern.compile(NUMBER_REGEX);
        ArrayList<Double> listNumbers = new ArrayList<Double>();
        Matcher matcher = patternPoint.matcher(inPut);

        if(matcher.find()) {
            matcher = patternNumber.matcher(inPut);

            while (matcher.find()) {
                listNumbers.add(Double.valueOf(matcher.group()));
            }
            double x = listNumbers.get(0);
            double y = listNumbers.get(1);
            return new Point(x, y);
        } else {
            LOGGER.log(Level.WARN, "Mistake created point " + inPut);
            return null;
        }

    }
}
