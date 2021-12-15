package kg.itschool.megashop.model.dto;

import kg.itschool.megashop.model.entity.Customer;
import kg.itschool.megashop.model.entity.Transaction;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {
    Long id;
    BigDecimal availableFunds;
    String accountNumber;
    Customer customer;
    TransactionDto lastDeposit;
    TransactionDto lastWithdraw;

}
