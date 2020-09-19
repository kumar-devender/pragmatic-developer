package info.pragmaticdeveloper;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringEncryptionTest {
    private StringEncryption stringEncryption;

    @BeforeEach
    void setUp() {
        stringEncryption = new StringEncryption();
    }

    @ParameterizedTest
    @MethodSource("encryptedDataProvider")
    void encryptString(String input, String expected) {
        String actual = stringEncryption.encryptString(input);
        MatcherAssert.assertThat(actual, CoreMatchers.equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("decryptedDataProvider")
    void decryptString(String input, String expected) {
        String actual = stringEncryption.decryptString(input);
        MatcherAssert.assertThat(actual, CoreMatchers.equalTo(expected));
    }

    private static Stream<Arguments> encryptedDataProvider() {
        return Stream.of(
                Arguments.of("WAAAYYFFFFFAIIIRR", "W1A3Y2F5A1I3R2")
        );
    }

    private static Stream<Arguments> decryptedDataProvider() {
        return Stream.of(
                Arguments.of("W1A3Y2F5A1I3R2", "WAAAYYFFFFFAIIIRR")
        );
    }
}