package kg.itschool.megashop.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends AbstractAuditable<Customer, Long> {

    @Column(name = "product_name", nullable = false)
    String productName;

    @Column(name = "available_products", nullable = false)
    Integer availableProducts;

    @Column(name = "price_for_one", nullable = false)
    BigDecimal priceForOne;

    @OneToMany
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    List<Category> category;

}
