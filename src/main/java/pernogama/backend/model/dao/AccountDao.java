package pernogama.backend.model.dao;

import org.springframework.data.repository.CrudRepository;
import pernogama.backend.model.entity.AccountEntity;

import java.util.List;

public interface AccountDao extends CrudRepository<AccountEntity, Long> {

    List<AccountEntity> findAll();

}
