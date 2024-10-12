package pernogama.backend.service;

import pernogama.backend.model.entity.CustomerEntity;

public interface ICustomer {

    CustomerEntity save(CustomerEntity customer);

    CustomerEntity findById(Long id);

    void delete(CustomerEntity customer);

}
