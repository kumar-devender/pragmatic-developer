package info.pragmaticdeveloper.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Item {
    private Integer id;
    private Integer price;
    private String name;

/*    @Override
    public String toString() {
        return "{\n" +
                '"' + "id" + '"' + ":" + id +
                ",\n" + '"' + "price" + '"' + ":" + price +
                ",\n" + '"' + "name" + '"' + ":" + '"' + name + '"' +
                "\n}";
    }*/
}
