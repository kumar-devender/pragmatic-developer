package info.pragmaticdeveloper.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    @Override
    public void print(String message) {
        graphics.forEach(graphic -> graphic.print(message));
    }
}
