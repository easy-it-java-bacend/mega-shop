package kg.itschool.megashop.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_order")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends BaseAuditable {

    @Column(name = "quantity", nullable = false, columnDefinition = "BIGINT DEFAULT 1")
    Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    Product product;

    @Column(name = "total_sum", nullable = false)
    BigDecimal orderSum;

    @PrePersist
    private void onCreate() {
        quantity = 1;
        orderSum = product.getPriceForOne().multiply(BigDecimal.valueOf(quantity));
    }
}
