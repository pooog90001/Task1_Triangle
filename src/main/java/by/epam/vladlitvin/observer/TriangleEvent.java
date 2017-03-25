package by.epam.vladlitvin.observer;

import by.epam.vladlitvin.entity.Triangle;

import java.util.EventObject;

/**
 * Created by vlad_ on 3/19/2017.
 */
public class TriangleEvent extends EventObject {

    public TriangleEvent(Triangle source) {
        super(source);
    }

    @Override
    public Triangle getSource() {
        return (Triangle) super.getSource();
    }
}
