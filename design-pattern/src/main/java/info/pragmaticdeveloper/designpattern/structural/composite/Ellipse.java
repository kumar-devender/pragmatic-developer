package info.pragmaticdeveloper.designpattern.structural.composite;

public class Ellipse implements Graphic {
    @Override
    public void print(String message) {
        System.out.println("Ellipse Calling " + message);
    }
}
