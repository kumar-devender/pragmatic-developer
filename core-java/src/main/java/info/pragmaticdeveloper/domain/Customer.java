package info.pragmaticdeveloper.domain;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Customer {
    @EqualsAndHashCode.Include
    private Integer id;
    private String name;
}
