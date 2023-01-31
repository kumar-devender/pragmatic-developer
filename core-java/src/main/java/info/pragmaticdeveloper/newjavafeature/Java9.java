package info.pragmaticdeveloper.newjavafeature;

import java.util.stream.Stream;

public class Java9 {
    public static void main(String[] args) {
        String result = Stream.iterate("a", s -> s)
                .limit(10)
                .reduce(String::concat)
                .get();
        System.out.println(result);
    }
}
