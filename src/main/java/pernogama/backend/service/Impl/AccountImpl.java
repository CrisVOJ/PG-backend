package pernogama.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pernogama.backend.model.dao.AccountDao;
import pernogama.backend.model.dao.TransactionDao;
import pernogama.backend.model.dto.TransactionDto;
import pernogama.backend.model.entity.AccountEntity;
import pernogama.backend.model.entity.TransactionEntity;
import pernogama.backend.service.IAccount;

import java.util.List;

@Service
public class AccountImpl implements IAccount {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionDao transactionDao;

    @Transactional
    @Override
    public AccountEntity save(AccountEntity account) {
        return accountDao.save(account);
    }

    @Transactional(readOnly = true)
    @Override
    public AccountEntity findById(Long id) {
        return accountDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountEntity> findAll() {
        return accountDao.findAll();
    }

    @Transactional
    @Override
    public void delete(AccountEntity account) {
        accountDao.delete(account);
    }

    @Transactional
    public void processTransaction(TransactionEntity transaction) {
        AccountEntity account = accountDao.findById(transaction.getAccount().getAccountId()).orElseThrow(() -> new RuntimeException("Account not found"));

        if (transaction.isMove()) {
            account.setBalance(account.getBalance().add(transaction.getAmount()));
        } else {
            account.setBalance(account.getBalance().subtract(transaction.getAmount()));
        }

        accountDao.save(account);
    }

    @Transactional
    public void updateTransaction(TransactionEntity transaction) {
        AccountEntity account = accountDao.findById(transaction.getAccount().getAccountId()).orElseThrow(() -> new RuntimeException("Account not found"));

        TransactionEntity oldTransaction = transactionDao.findById(transaction.getTransactionId()).orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (transaction.isMove()) {
            account.setBalance(account.getBalance().subtract(oldTransaction.getAmount()).add(transaction.getAmount()));
        } else {
            account.setBalance(account.getBalance().add(oldTransaction.getAmount().subtract(transaction.getAmount())));
        }

        accountDao.save(account);
    }

    @Transactional
    public void deleteTransaction(TransactionDto transactionDto, Long accountId) {
        AccountEntity account = accountDao.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));

        if (transactionDto.isMove()) {
            account.setBalance(account.getBalance().subtract(transactionDto.getAmount()));
        } else {
            account.setBalance(account.getBalance().add(transactionDto.getAmount()));
        }

        accountDao.save(account);
    }
}
