package info.pragmaticdeveloper.comparision.example;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BadInventory {
    private final List<Supply> supplies;

    public List<Supply> find(@NonNull final String regex) {
        return supplies.stream()
                .filter(supply -> Pattern.matches(regex, supply.getName()))
                .collect(Collectors.toList());
    }
}
