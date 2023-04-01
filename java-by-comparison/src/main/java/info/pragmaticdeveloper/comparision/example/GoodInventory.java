package info.pragmaticdeveloper.comparision.example;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GoodInventory {
    private final List<Supply> supplies;

    public List<Supply> find(@NonNull final String regex) {
        var pattern = Pattern.compile(regex);
        return supplies.stream()
                .filter(supply -> pattern.matcher(supply.getName()).matches())
                .collect(Collectors.toList());
    }
}
