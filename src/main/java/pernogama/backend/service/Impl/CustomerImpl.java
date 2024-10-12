package pernogama.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pernogama.backend.model.dao.CustomerDao;
import pernogama.backend.model.entity.CustomerEntity;
import pernogama.backend.service.ICustomer;

@Service
public class CustomerImpl implements ICustomer {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    @Override
    public CustomerEntity save(CustomerEntity customer) {
        return customerDao.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public CustomerEntity findById(Long id) {
        return customerDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(CustomerEntity customer) {
        customerDao.delete(customer);
    }
}
