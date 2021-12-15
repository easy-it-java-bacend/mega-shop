package kg.itschool.megashop.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_transaction")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction extends AbstractPersistable<Long> {

    @CreationTimestamp
    @Column(name = "transaction_date", nullable = false, updatable = false)
    Date transactionDate;

    @OneToOne
    @JoinColumn(name = "withdraw_from", referencedColumnName = "id")
    Account withdrawFrom;

    @OneToOne
    @JoinColumn(name = "deposit_to_account", referencedColumnName = "id")
    Account depositToAccount;

    @Column(name = "transaction_amount", nullable = false)
    BigDecimal transactionAmount;
}
