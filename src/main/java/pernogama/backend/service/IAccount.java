package pernogama.backend.service;

import pernogama.backend.model.entity.AccountEntity;

import java.util.List;

public interface IAccount {

    AccountEntity save(AccountEntity account);

    AccountEntity findById(Long id);

    List<AccountEntity> findAll();

    void delete(AccountEntity account);
}
