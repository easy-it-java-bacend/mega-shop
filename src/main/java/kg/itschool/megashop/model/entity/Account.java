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
@Table(name = "tb_account")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account extends BaseAuditable {

    @Column(name = "available_funds", nullable = false)
    BigDecimal availableFunds;

    @Column(name = "account_number", nullable = false)
    String accountNumber;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;

    @OneToOne
    @JoinColumn(name = "last_deposit_transaction_id", referencedColumnName = "id")
    Transaction lastDeposit;

    @OneToOne
    @JoinColumn(name = "last_withdraw_transaction_id", referencedColumnName = "id")
    Transaction lastWithdraw;

}
