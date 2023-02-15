package info.pragmaticdeveloper.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Trader {
    private final String name;
    private final String city;
}
