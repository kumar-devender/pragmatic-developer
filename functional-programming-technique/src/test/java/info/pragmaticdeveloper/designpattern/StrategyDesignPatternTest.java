package info.pragmaticdeveloper.designpattern;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StrategyDesignPatternTest {
    private StrategyDesignPattern strategyDesignPattern;
    private List<Integer> items;

    @BeforeEach
    void setUp() {
        strategyDesignPattern = new StrategyDesignPattern();
        items = IntStream
                .range(1, 6)
                .boxed()
                .collect(Collectors.toList());
    }

    @Test
    void testEvenTotal() {
        assertThat(strategyDesignPattern.total(items, item -> item % 2 == 0), is(6) );
    }

    @Test
    void testOddTotal() {
        assertThat(strategyDesignPattern.total(items, item -> item % 2 != 0), is(9) );
    }

    @Test
    void testAllTotal() {
        assertThat(strategyDesignPattern.total(items, Objects::nonNull), is(15) );
    }

}