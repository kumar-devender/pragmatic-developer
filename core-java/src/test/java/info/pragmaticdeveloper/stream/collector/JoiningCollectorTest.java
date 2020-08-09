package info.pragmaticdeveloper.stream.collector;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static info.pragmaticdeveloper.stream.TestDataProvider.itemNames;

public class JoiningCollectorTest {
    @Test
    void testMutableReductionJoiningByDelimiterAndPrefixAndSuffix() {
        String joinedNameWithPrefixAndSuffix = itemNames.stream()
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinedNameWithPrefixAndSuffix);
    }

    @Test
    public void testMutableReductionJoiningByDelimiter() {
        String joinedNameCommaSeparated = itemNames.stream()
                .collect(Collectors.joining(","));
        System.out.println(joinedNameCommaSeparated);
    }

    @Test
    public void testMutableReductionJoiningByCustomCollector() {
        String joinedName = itemNames.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        System.out.println(joinedName);
    }

    @Test
    public void testMutableReductionJoining() {
        String joinedName = itemNames.stream()
                .collect(Collectors.joining());
        System.out.println(joinedName);
    }
}
