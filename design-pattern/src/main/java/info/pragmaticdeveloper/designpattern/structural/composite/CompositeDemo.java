package info.pragmaticdeveloper.designpattern.structural.composite;

public class CompositeDemo {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Ellipse ellipse = new Ellipse();
        Square square = new Square();
        CompositeGraphic compositeGraphic1 = new CompositeGraphic();
        compositeGraphic1.add(ellipse);
        CompositeGraphic compositeGraphic2 = new CompositeGraphic();
        compositeGraphic2.add(ellipse);
        CompositeGraphic compositeGraphic3 = new CompositeGraphic();
        compositeGraphic3.add(square);

        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(compositeGraphic1);
        compositeGraphic.add(compositeGraphic2);
        compositeGraphic.add(compositeGraphic3);
        compositeGraphic.add(circle);
        compositeGraphic.print("Hello world!");
    }
}
