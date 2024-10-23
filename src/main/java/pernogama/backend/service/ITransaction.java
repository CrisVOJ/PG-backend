package pernogama.backend.service;

import pernogama.backend.model.dto.TransactionDto;
import pernogama.backend.model.entity.AccountEntity;
import pernogama.backend.model.entity.TransactionEntity;

import java.util.List;

public interface ITransaction {

    TransactionDto save(Long accountId, TransactionDto transactionDto);

    TransactionDto findById(Long id);

    List<TransactionDto> findAll();

    List<TransactionDto> findAllByAccount_AccountId(Long accountId);

    void deleteById(Long id, Long accountId);

}
