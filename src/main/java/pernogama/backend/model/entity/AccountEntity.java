package pernogama.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "accounts")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "name")
    private String name;
    @Column(name = "balance")
    private BigDecimal balance;

}
