package pernogama.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "transactions")
public class TransactionEntity implements Serializable {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "move")
    private boolean move;
    @Column(name = "description")
    private String description;
    @Column(name = "date_time")
    private Date dateTime;

}
