package info.pragmaticdeveloper.comparision.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class BadInventoryTest {

    @Test
    void findShouldReturnCorrectMatchingSupplies() {
        //given
        var supplies = Stream.of(
                        buildSupplies(100_0000, "Wheat"),
                        buildSupplies(150_000, "Rice"),
                        buildSupplies(50_000, "Gram floor"),
                        buildSupplies(50_000, "Barley")
                ).flatMap(List::stream)
                .collect(Collectors.toList());
        BadInventory badInventory = new BadInventory(supplies);
        //when
        var startTime = System.currentTimeMillis();
        var result = badInventory.find("Wheat");
        var finishTime = System.currentTimeMillis();
        // then
        System.out.println((finishTime - startTime) / 10);
        assertThat(result, hasSize(100_0000));
    }

    private List<Supply> buildSupplies(int number, String name) {
        return IntStream.range(0, number)
                .mapToObj(index -> new Supply(name))
                .collect(Collectors.toList());
    }
}
