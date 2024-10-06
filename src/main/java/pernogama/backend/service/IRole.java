package pernogama.backend.service;

import pernogama.backend.model.entity.RoleEntity;

public interface IRole {

    RoleEntity save(RoleEntity role);

    RoleEntity findById(Long id);

    void delete(RoleEntity role);

}
