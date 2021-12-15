package kg.itschool.megashop.model.dto;

import kg.itschool.megashop.model.entity.Account;
import kg.itschool.megashop.model.entity.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {
    Long id;
    String email;
    String phoneNumber;
    AddressDto address;
    AccountDto account;
}
