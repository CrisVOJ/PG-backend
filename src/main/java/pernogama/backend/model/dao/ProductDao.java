package pernogama.backend.model.dao;

import org.springframework.data.repository.CrudRepository;
import pernogama.backend.model.entity.ProductEntity;

import java.util.List;

public interface ProductDao extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();

}
