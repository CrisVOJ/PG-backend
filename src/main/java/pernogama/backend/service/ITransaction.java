package pernogama.backend.service;

import pernogama.backend.model.entity.AccountEntity;
import pernogama.backend.model.entity.TransactionEntity;

import java.util.List;

public interface ITransaction {

    TransactionEntity save(TransactionEntity transaction);

    TransactionEntity findById(Long id);

    List<TransactionEntity> findAll();

    List<TransactionEntity> findAllByAccount_AccountId(Long accountId);

    void delete(TransactionEntity transaction);

}
