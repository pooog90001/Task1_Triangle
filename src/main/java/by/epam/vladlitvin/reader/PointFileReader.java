package by.epam.vladlitvin.reader;

import by.epam.vladlitvin.exception.FileReadException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.ArrayList;


/**
 * Created by vlad_ on 3/18/2017.
 */
public class PointFileReader {
    private final static Logger LOGGER = LogManager.getLogger(PointFileReader.class.getName());

    public static ArrayList<String> readFile(String fileName) throws FileReadException {
        ArrayList<String> listStrings = new ArrayList<String>();

        try (BufferedReader reader = new BufferedReader( new FileReader(fileName))){
            reader.lines().forEach(listStrings::add);
            LOGGER.log(Level.INFO,"With file " + fileName + "read" +
                    listStrings.size() + "lines: " + listStrings.toString());

        } catch (FileNotFoundException e) {
            LOGGER.log(Level.FATAL,"This file not found " + e);
            throw new RuntimeException(e.getMessage(), e);

        } catch (IOException e) {
            LOGGER.log(Level.ERROR,"Error file reading " + e.getMessage());
            throw new FileReadException("The file is unreadable", e);
        }

        return listStrings;
    }

}
