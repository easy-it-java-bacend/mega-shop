package kg.itschool.megashop.model.dto;

import kg.itschool.megashop.model.entity.Customer;
import kg.itschool.megashop.model.entity.Order;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasketDto {
    Long id;
    List<OrderDto> orders;
    BigDecimal totalSum;
    CustomerDto customer;
}
