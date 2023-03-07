package info.pragmaticdeveloper.dsa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ExpressionEvaluationTest {

    @ParameterizedTest
    @CsvSource({"(1+((2+3)*(4*5))), 101"})
    void evaluate(String input, int expected) {
        int result = new ExpressionEvaluation().evaluate(input);
        assertThat(result, is(expected));
    }
}