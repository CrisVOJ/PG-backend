package pernogama.backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;
    @Column(name = "amount")
    private double amount;
    @Column(name = "move")
    private boolean move;
    @Column(name = "description")
    private String description;
    @Column(name = "date_time")
    private Date dateTime;

}
