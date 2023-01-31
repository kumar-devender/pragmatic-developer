package info.pragmaticdeveloper;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("Java", "Magazine", "is",
                "the", "best");
        Map<String, Long> contMap = words
                .map(w -> w.split(""))
                //flatMap lets you replace each value of a stream with another stream, and then it concatenates all the generated streams into one single stream.
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(contMap);
    }
}
