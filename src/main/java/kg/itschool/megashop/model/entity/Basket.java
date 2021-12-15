package kg.itschool.megashop.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_basket")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Basket extends BaseAuditable {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    List<Order> orders;

    @Column(name = "total_sum", nullable = false)
    BigDecimal totalSum;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;

    @PostUpdate
    private void onUpdate() {
        totalSum = orders.stream().map(Order::getOrderSum).reduce(BigDecimal::add).get();
    }

}
