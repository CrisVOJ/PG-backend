package pernogama.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pernogama.backend.model.dao.AccountDao;
import pernogama.backend.model.entity.AccountEntity;
import pernogama.backend.service.IAccount;

import java.util.List;

@Service
public class AccountImpl implements IAccount {

    @Autowired
    private AccountDao accountDao;

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
}
