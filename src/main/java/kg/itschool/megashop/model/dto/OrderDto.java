package kg.itschool.megashop.model.dto;

import kg.itschool.megashop.model.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long id;
    Integer quantity;
    ProductDto product;
    BigDecimal orderSum;
}
