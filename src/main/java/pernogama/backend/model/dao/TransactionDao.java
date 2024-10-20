package pernogama.backend.model.dao;

import org.springframework.data.repository.CrudRepository;
import pernogama.backend.model.entity.AccountEntity;
import pernogama.backend.model.entity.TransactionEntity;

import java.util.List;

public interface TransactionDao extends CrudRepository<TransactionEntity, Long> {

    List<TransactionEntity> findAll();

    List<TransactionEntity> findAllByAccount_AccountId(Long accountId);
}
