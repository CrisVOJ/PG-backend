package pernogama.backend.service;

import pernogama.backend.model.entity.ProductEntity;

import java.util.List;

public interface IProduct {

    ProductEntity save(ProductEntity product);

    ProductEntity findById(Long id);

    List<ProductEntity> findAll();

    void delete(ProductEntity product);

}
