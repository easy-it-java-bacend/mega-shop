package kg.itschool.megashop.model.dto;

import kg.itschool.megashop.model.entity.Account;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionDto {
    Long id;
    Date transactionDate;
    Account withdrawFrom;
    AccountDto depositToAccount;
    BigDecimal transactionAmount;
}
