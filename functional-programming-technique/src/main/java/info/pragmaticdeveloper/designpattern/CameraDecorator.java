package info.pragmaticdeveloper.designpattern;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.function.Function.identity;


public class CameraDecorator {
    private final Function<Color, Color> filter;

    public CameraDecorator(Function<Color, Color>... filters) {
//        filter = Stream.of(filters)
//                .reduce(identity(), (aFilter, result) -> result.andThen(aFilter));
        filter = Stream.of(filters)
                .reduce(identity(), Function::andThen);
    }

    public Color snap(Color color) {
        return filter.apply(color);
    }
}
