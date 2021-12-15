package kg.itschool.megashop.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDto {
    Long id;
    String state;
    String region;
    String cityName;
    String streetName;
    String streetNameOptional;
    String house;
    String postalCode;
}
