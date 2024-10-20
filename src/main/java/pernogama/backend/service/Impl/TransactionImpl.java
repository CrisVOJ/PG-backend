package pernogama.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pernogama.backend.model.dao.AccountDao;
import pernogama.backend.model.dao.TransactionDao;
import pernogama.backend.model.entity.AccountEntity;
import pernogama.backend.model.entity.TransactionEntity;
import pernogama.backend.service.ITransaction;

import java.util.List;

@Service
public class TransactionImpl implements ITransaction {

    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private AccountDao accountDao;

    @Override
    public TransactionEntity save(TransactionEntity transaction) {
        AccountEntity account = accountDao.findById(transaction.getAccount().getAccountId()).orElse(null);
        transaction.setAccount(account);
        return transactionDao.save(transaction);
    }

    @Override
    public TransactionEntity findById(Long id) {
        return transactionDao.findById(id).orElse(null);
    }

    @Override
    public List<TransactionEntity> findAll() {
        return transactionDao.findAll();
    }

    @Override
    public List<TransactionEntity> findAllByAccount_AccountId(Long accountId) {
        return transactionDao.findAllByAccount_AccountId(accountId);
    }

    @Override
    public void delete(TransactionEntity transaction) {
        transactionDao.delete(transaction);
    }
}
