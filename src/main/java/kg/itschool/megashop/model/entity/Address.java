package kg.itschool.megashop.model.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_address")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address extends AbstractPersistable<Long> {

    @Column(name = "state", nullable = false)
    String state;

    @Column(name = "region", nullable = false)
    String region;

    @Column(name = "city_name", nullable = false)
    String cityName;

    @Column(name = "street_name", nullable = false)
    String streetName;

    @Column(name = "street_name_optional", nullable = true)
    String streetNameOptional;

    @Column(name = "house", nullable = false)
    String house;

    @Column(name = "postal_code", nullable = false)
    String postalCode;

}
