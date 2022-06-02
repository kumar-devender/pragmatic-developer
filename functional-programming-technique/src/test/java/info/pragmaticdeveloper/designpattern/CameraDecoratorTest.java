package info.pragmaticdeveloper.designpattern;

import org.junit.jupiter.api.Test;

import java.awt.*;

public class CameraDecoratorTest {
    @Test
    void testDecorator() {
        CameraDecorator cameraDecorator = new CameraDecorator(Color::brighter, Color::darker);
        System.out.println(cameraDecorator.snap(new Color(125, 125, 125)));
    }

}