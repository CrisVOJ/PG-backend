package pernogama.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pernogama.backend.Globals;
import pernogama.backend.model.dao.ProductDao;
import pernogama.backend.model.entity.ProductEntity;
import pernogama.backend.service.IProduct;

import java.util.List;

@RestController
@RequestMapping(Globals.apiVersion + "product")
public class ProductController {

    @Autowired
    private IProduct productService;

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity product) {
        return productService.save(product);
    }

    @PutMapping
    public ProductEntity update(@RequestBody ProductEntity product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public ProductEntity findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ProductEntity productDelete = productService.findById(id);
        productService.delete(productDelete);
    }
}
