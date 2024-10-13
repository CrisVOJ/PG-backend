package pernogama.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pernogama.backend.model.dao.ProductDao;
import pernogama.backend.model.entity.ProductEntity;
import pernogama.backend.service.IProduct;

import java.util.List;

@Service
public class ProductImpl implements IProduct {

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public ProductEntity save(ProductEntity product) {
        return productDao.save(product);
    }

    @Transactional(readOnly = true)
    @Override
    public ProductEntity findById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductEntity> findAll() {
        return productDao.findAll();
    }

    @Transactional
    @Override
    public void delete(ProductEntity product) {
        productDao.delete(product);
    }
}
