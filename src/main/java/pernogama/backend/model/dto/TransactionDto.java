package pernogama.backend.model.dto;

import jakarta.persistence.*;
import lombok.*;
import pernogama.backend.model.entity.AccountEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@Builder
public class TransactionDto implements Serializable {

    private Long transactionId;
    private BigDecimal amount;
    private boolean move;
    private String description;
    private Date dateTime;

}
