package info.pragmaticdeveloper.domain;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @EqualsAndHashCode.Include
    private Integer id;
    private Integer amount;
    private CountryCode country;
    //private List<Item> cart;
    private Customer customer;
}
