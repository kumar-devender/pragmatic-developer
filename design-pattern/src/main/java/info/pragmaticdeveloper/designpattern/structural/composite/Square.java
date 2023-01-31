package info.pragmaticdeveloper.designpattern.structural.composite;

public class Square implements Graphic {
    @Override
    public void print(String message) {
        System.out.println("Square is calling " + message);
    }
}
