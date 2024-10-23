package pernogama.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pernogama.backend.model.dao.AccountDao;
import pernogama.backend.model.dao.TransactionDao;
import pernogama.backend.model.dto.AccountDto;
import pernogama.backend.model.dto.TransactionDto;
import pernogama.backend.model.entity.AccountEntity;
import pernogama.backend.model.entity.TransactionEntity;
import pernogama.backend.service.ITransaction;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionImpl implements ITransaction {

    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private AccountImpl accountImpl;

    @Override
    public TransactionDto save(Long accountId, TransactionDto transactionDto) {
        AccountEntity account = accountImpl.findById(accountId);

        TransactionEntity transaction = convertToEntity(transactionDto);
        transaction.setAccount(account);

        if (transaction.getTransactionId() == null) {
            accountImpl.processTransaction(transaction);
        } else {
            accountImpl.updateTransaction(transaction);
        }

        return convertToDto(transactionDao.save(transaction));
    }

    @Override
    public TransactionDto findById(Long id) {
        return convertToDto(transactionDao.findById(id).orElse(null));
    }

    @Override
    public List<TransactionDto> findAll() {
        List<TransactionEntity> transactions = transactionDao.findAll();

        return transactions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDto> findAllByAccount_AccountId(Long accountId) {
        List<TransactionEntity> transactions = transactionDao.findAllByAccount_AccountId(accountId);

        return transactions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long transactionId, Long accountId) {
        TransactionDto transactionDto = findById(transactionId);
        accountImpl.deleteTransaction(transactionDto, accountId);
        transactionDao.deleteById(transactionId);
    }

    private TransactionDto convertToDto (TransactionEntity transaction) {
        TransactionDto transactionDto = TransactionDto.builder().build();

        transactionDto.setTransactionId(transaction.getTransactionId());
        transactionDto.setMove(transaction.isMove());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setDateTime(transaction.getDateTime());

        return transactionDto;
    }

    private TransactionEntity convertToEntity (TransactionDto transactionDto) {
        TransactionEntity transaction = TransactionEntity.builder().build();

        transaction.setTransactionId(transactionDto.getTransactionId());
        transaction.setMove(transactionDto.isMove());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDescription(transactionDto.getDescription());
        transaction.setDateTime(transactionDto.getDateTime());

        return transaction;
    }
}
