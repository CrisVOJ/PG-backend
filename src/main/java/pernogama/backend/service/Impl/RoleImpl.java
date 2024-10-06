package pernogama.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pernogama.backend.model.dao.RoleDao;
import pernogama.backend.model.entity.RoleEntity;
import pernogama.backend.service.IRole;

@Service
public class RoleImpl implements IRole {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public RoleEntity save(RoleEntity role) {
        return roleDao.save(role);
    }

    @Transactional(readOnly = true)
    @Override
    public RoleEntity findById(Long id) {
        return roleDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(RoleEntity role) {
        roleDao.delete(role);
    }
}
