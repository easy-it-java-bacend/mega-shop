package kg.itschool.megashop.model.dto;

import kg.itschool.megashop.model.entity.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    Long id;
    String productName;
    Integer availableProducts;
    BigDecimal priceForOne;
    List<CategoryDto> category;

}
