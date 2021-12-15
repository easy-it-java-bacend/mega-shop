package kg.itschool.megashop.model.request;

import kg.itschool.megashop.model.dto.AddressDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCustomerRequest {

    @NonNull
    String email;

    @NonNull
    String phoneNumber;

    @NonNull
    AddressDto address;
}
