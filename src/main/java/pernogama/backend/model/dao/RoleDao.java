package pernogama.backend.model.dao;

import org.springframework.data.repository.CrudRepository;
import pernogama.backend.model.entity.RoleEntity;

public interface RoleDao extends CrudRepository<RoleEntity, Long> {
}
