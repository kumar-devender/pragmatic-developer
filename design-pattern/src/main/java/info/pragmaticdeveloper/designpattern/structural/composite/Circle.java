package info.pragmaticdeveloper.designpattern.structural.composite;

public class Circle implements Graphic{
    @Override
    public void print(String message) {
        System.out.println("Circle is calling "+ message);
    }
}
