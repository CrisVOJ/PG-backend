package pernogama.backend.model.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@Builder
public class AccountDto implements Serializable {

    private Long accountId;
    private String name;
    private BigDecimal balance;

}
