package pernogama.backend.model.dao;

import org.springframework.data.repository.CrudRepository;
import pernogama.backend.model.entity.CustomerEntity;

public interface CustomerDao extends CrudRepository<CustomerEntity, Long> {
}
